package com.lec.ex5_personinfo;

public class PersonInfoTestMain {
	public static void main(String[] args) {
		int i = 10;
//		int[] arr = {1,2,3};
		int[] arr = new int[3];
		arr[0] = 1; arr[1] = 2; arr[2] = 3;
		for(int idx=0 ; idx<arr.length ; idx++) { // 일반for문
			System.out.println(arr[idx]);
		}
		for(int a : arr) { // 확장for문
			System.out.println(a);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		PersonInfo p1 = new PersonInfo("홍", 32, 'f');
//		PersonInfo[] person = {new PersonInfo("홍길동", 25, 'f'), new PersonInfo("홍길순", 25, 'm')};
		PersonInfo[] person = new PersonInfo[2];
		person[0] = p1;
		person[1] = new PersonInfo("홍길순", 25, 'f');
//		for(int idx=0 ; idx<person.length ; idx++) { // 일반for문
//			// person[idx].print();
//			System.out.println(person[idx].infoString());
//		}
		for(PersonInfo p : person) { // 확장for문
			System.out.println(p.infoString());
		}
	}
}
