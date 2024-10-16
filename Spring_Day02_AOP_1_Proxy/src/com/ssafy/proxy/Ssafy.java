package com.ssafy.proxy;

import java.util.Random;

public class Ssafy {
	// 필드는 생략!
	
	public void coding() {
		System.out.println("컴퓨터를 부팅한다."); // 이전 수행 기능
		
		try {
			System.out.println("열심히 공부를 한다."); // 핵심관심사항
			if (new Random().nextBoolean()) {
				throw new OuchException();
			}			
			System.out.println("Git에 Commit한다."); // 정상 마무리 기능
		} catch (OuchException e) {
			e.handleException();
			System.out.println("조퇴를 한다."); // 비정상 마무리
		} finally {
			System.out.println("침대와 한 몸이 된다."); // 모든 게 마무리 되었을 때!
		}
		
		
	}
}
