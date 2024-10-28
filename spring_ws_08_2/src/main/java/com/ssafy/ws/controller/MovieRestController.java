package com.ssafy.ws.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.MovieService;
import com.ssafy.ws.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/movieapi")
@CrossOrigin("*")
public class MovieRestController {
	@Autowired
	MovieService ms;

	@Autowired
	UserService us;

	// GetMapping
	// search(READ)
	@GetMapping("/movie/{title}")
	@ApiOperation(value = "{title}에 해당하는 영화 정보를 반환한다.", response = Movie.class)
	public ResponseEntity<?> select(@PathVariable String title) {
		try {
			List<Movie> movies = ms.search(title);
			if (movies != null && movies.size() > 0) {
				return new ResponseEntity<Movie>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Movie>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/movie")
	@ApiOperation(value = "등록된 모든 영화 정보를 반환한다.", response = Movie.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<Movie> movies = ms.selectAll();
			if (movies != null && movies.size() > 0) {
				return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// PostMapping
	// insert(CREATE)
	@PostMapping("/movie")
	@ApiOperation(value = "movie 객체를 저장한다.", response = Integer.class)
	public ResponseEntity<?> insert(Movie movie, @RequestPart(required = false) MultipartFile file) {
		try {
			int result = ms.insert(movie, file);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/movie/{id}")
	@ApiOperation(value = "movie 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable int id) {
		try {
			int result = ms.delete(id);
			if (result == 0) {
				return new ResponseEntity<Integer>(result, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// GetMapping
	// select(READ)
	@GetMapping("/user/{id}")
	@ApiOperation(value = "{id}에 해당하는 user를 반환한다.", response = User.class)
	public ResponseEntity<?> selectUser(@PathVariable String id) {
		try {
			User user = us.select(id);
			if (user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
}
