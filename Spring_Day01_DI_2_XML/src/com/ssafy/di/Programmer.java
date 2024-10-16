package com.ssafy.di;

public class Programmer {
	private Computer computer;

	// 객체 생성 의존성 제거
	public Programmer(Computer computer) {
		// 가지고 있는 데스크탑 한 개 줘!
		this.computer = computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}
}