package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyBatisConfig;
import com.ssafy.board.dto.Board;

public class Test {
	public static void main(String[] args) {
		try (SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board : boards) {
				System.out.println(board);
			}
		}
	}
}