package com.ssafy.mvc.controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	// final 써도 밑에 생성자 있어서 빨간 줄 안 뜸
	// final 쓸 거면 autowired 쓰지 말아라?
	private final BoardService boardService;
	
//	@Autowired 생성자가 하나라 알아서 들어갈 거라 안 써도 된다
	public BoardController(BoardService boardservice) {
		this.boardService = boardservice;
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		return "/board/list";
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		return "board/writeform";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		return "redirect:/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id")int id, Model model) {
		//게시글을 하나 가지고와서 updateform으로 넘겨야된다.
		//지금은 readBoard 밖에 없어서.. 이걸로 하긴 하겠지만.. 이거 하면 게시글 조회수 하나 올라감
		//그냥 쌩 게시글 하나 가져오는것 고민할 필요가 있다...
		model.addAttribute("board", boardService.readBoard(id));
		return "/board/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}
}
