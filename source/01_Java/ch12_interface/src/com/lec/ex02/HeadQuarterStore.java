package com.lec.ex02;
// 추상클래스 : 하나 이상의 추상메소드를 갖고 있으면 추상클래스
public interface HeadQuarterStore {
	// 추상메소드 : 나를 상속한 클래스에서 반드시 override 해라.
	//			  메소드의 선언만 
	public void kimchi();
	public void bude();
	public abstract void bibim();
	public void sunde();
	public abstract void gongibab();
	public String getStoreName();
}

