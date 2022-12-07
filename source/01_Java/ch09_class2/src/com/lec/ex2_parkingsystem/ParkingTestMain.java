package com.lec.ex2_parkingsystem;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111루1111", 6);
		Parking car2 = new Parking("222루2222", 8);
		car1.out(8);
		car2.out(9);
		Parking car3 = new Parking("333루3333", 10);
//		Parking[] cars = {car1, car2, car3};
//		String[] title = {"번호","입차시간","출차시간","주차요금"};
//		int out = new int[2];
//		System.out.println("11라1111님 어서오세요");
//		for(String t : title) {
//			System.out.print("\t" + t);
//		}
//		for(Parking parking : cars) {
//			System.out.println(parking.infoString());
//		}
//		System.out.println();
	}	
}
