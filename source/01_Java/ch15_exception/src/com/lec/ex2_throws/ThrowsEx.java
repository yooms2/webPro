package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception {
		actionC();
	}
	private void actionC() throws IndexOutOfBoundsException {
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws IndexOutOfBoundsException {
		System.out.println("actionB ���ݺ�");
		actionA();
		System.out.println("actionB �Ĺݺ�");
	}
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA ���ݺ�");
		int[] arr = {0,1,2};
		System.out.println(arr[3]);
		System.out.println("actionA �Ĺݺ�");
	}
}
