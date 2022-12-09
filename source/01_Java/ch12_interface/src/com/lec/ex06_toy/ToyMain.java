package com.lec.ex06_toy;

public class ToyMain {
	public static void main(String[] args) {
		PoohToy pooh = new PoohToy();
		MazingerToy mazinger = new MazingerToy();
		AirplaneToy airplane = new AirplaneToy();
		IToy[] toy = {pooh, mazinger, airplane};
		for(IToy t : toy) {
			// ��ü�� Ŭ���� �̸� ���
			System.out.println(t.getClass().getName());
		}
	}
}
