package com.interfaces.advanced;

public class Audio {
	void musicPlay(Playable lp) {
		// 매개변수에서의 다형성 + 인터페이스(Playable)와 다형성
		// Playable lp = new Park();
		// (상위 타입)			(하위 타입)
		lp.play();
	}
	

}
