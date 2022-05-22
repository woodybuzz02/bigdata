package com.interfaces.advanced;

public class App {

	public static void main(String[] args) {
		// 음악을 재생해야되기 때문에, Audio 인스턴스 lpRecode 생성
		Audio lpRecode = new Audio();
		
		// lpRecoder musicPlay(재생할 앨범)을 호출하면 넣은 앨범의 음악이 재생됨.
		
		Joy joyAlbum = new Joy();
		
		Park parkAlbum = new Park();
		
		lpRecode.musicPlay(parkAlbum);

	}

}
