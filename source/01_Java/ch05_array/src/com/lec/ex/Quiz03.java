package com.lec.ex;

public class Quiz03 {
	public static void main(String[] args) {
		int[] arr = {500,100,50,10};	
		int tot = 2680;
		System.out.println("�� �ݾ� = " + tot);
		for(int i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i] + "¥�� "+tot/arr[i]  + "��");
			tot  %= arr[i]; //tot = tot % arr[i];
		}
		
	}
}
