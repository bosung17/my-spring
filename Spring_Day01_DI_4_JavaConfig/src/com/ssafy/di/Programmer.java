package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//컴퓨터 필요해!
@Component(value="p")
public class Programmer {
	private Computer computer;

	public Programmer() {
	}
	
	// 생성자 주입
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	// 설정자를 이용해서 주입
	@Autowired
	public void setComputer(@Qualifier("desktop") Computer computer) {
		this.computer = computer;
	}
	
	//메서드를 토앻서 주입을 할수도 있어! (중간에 바꾸거나.. 그런작업을 할때)
	
	

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 합니다.");
	}
}
