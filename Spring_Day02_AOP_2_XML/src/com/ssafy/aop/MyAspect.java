package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

// 공통 관심사항을 한 번에 저장할 클래스
public class MyAspect {

	public void before() {
		System.out.println("컴퓨터를 부팅한다."); // 이전 수행 기능
	}

	public void afterReturning(int num) {
		System.out.println("Git에 Commit한다." + num + "시간을"); // 정상 마무리 기능
	}

	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	public void after() {
		System.out.println("침대와 한 몸이 된다."); // 모든 게 마무리 되었을 때!
	}
	
	//////////////////////////////////////////////////
	
	public int around(ProceedingJoinPoint pjt) {
		int num = 0;
		
		this.before();
		try {
			num = (int) pjt.proceed();
			this.afterReturning(num);
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
		return num;
	}
}
