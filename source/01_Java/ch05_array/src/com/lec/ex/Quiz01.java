package com.lec.ex;

public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50} ;
		int tot = 0 ;
		for(int i=0 ; i<arr.length ; i++) {
			tot += arr[i];
			System.out.print(arr[i]);
			if(i != arr.length-1) {
				System.out.print("+");
			}
		}
		System.out.print("="+tot);
	}
}