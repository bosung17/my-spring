package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api-board")
@Tag(name="BoardRestful API", description = "게시판 CRUD")
public class BoardRestController {
	// 서비스 의존성 주입
	private final BoardService boardService;
	
//	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 게시글 전체 조회
	// ResponseEntity 제네릭 안에 아무거나 들어가도 되는 와일드카드 ? 써도 됨!
//	@GetMapping("/board")
//	public ResponseEntity<List<Board>> list(){
//		List<Board> list = boardService.getBoardList();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	// 게시글 검색
	@GetMapping("/board")
	@Operation(summary = "게시글 검색 및 조회", description = "조건에 따른 검색을 수행할 수 있습니다.")
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition){
		System.out.println(condition);
		List<Board> list = boardService.search(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id){
		Board board = boardService.readBoard(id);
//		System.out.println(board);
		if (board != null) {
			return ResponseEntity.ok(board);			
		}
		// 의도한 에러
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	// 게시글 등록 (json이 아니라 form 데이터 형식으로 넘어왔다고 가정)
	@PostMapping("/board")
	public ResponseEntity<?> write(@ModelAttribute Board board){
		// 게시글 등록 요청 (원래는 int반환인데 일단은 하던대로 void로 함)
		boardService.writeBoard(board);
		System.out.println(board);
		
		int id = board.getId();
		// 입력한 보드 자체를 넘겼는데 의미가 있을까?
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	// 게시글 삭제
	@DeleteMapping("board/{id}")
	@Hidden // 숨기기
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		boolean isDeleted = boardService.removeBoard(id);
		
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Board deleted");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	
	// 게시글 수정
	@PutMapping("board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board){ // RequestBody import 잘하기 (swagger에 있는 거 하면 안 됨)
		board.setId(id);
		boardService.modifyBoard(board);
		// 무조건 성공!으로 해뒀지만 컨트롤 가능한 부분
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<Void> fileUpload(@RequestParam("file") MultipartFile file, @ModelAttribute Board board){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(board);
		
		boardService.fileUpload(file, board);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
