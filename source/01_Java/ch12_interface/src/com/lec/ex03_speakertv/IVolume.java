package com.lec.ex03_speakertv;
// 인터페이스 - static final 변수(상수)와 추상메소드 (예외 : default메소드, static 메소드)
// 작업명세서 역할
public interface IVolume {
	public void volumUp(); // 볼륨 레벨을 1씩 up
	public void volumUp(int level); // 볼륨 레벨을 level씩 up
	public void volumDown(); // 볼륨 레벨을 1씩 down
	public void volumDown(int level); // 볼륨 레벨을 level씩 down
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음");
		}else {
			System.out.println("무음해제");
		}
	}
	public static void changeBattery() { // static 메소드
		System.out.println("건전지를 교환합니다");
	}
}
