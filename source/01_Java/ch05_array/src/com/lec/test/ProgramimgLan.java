package com.lec.test;

public class ProgramimgLan {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,93} ;
		int tot = 0 ;
		int avg = 0 ;
		int max = 0, maxnum = 0 ;
		int min = 0, minnum = 999 ;
		for(int i=0 ; i<arr.length ; i++)
			tot += arr[i] ;
		System.out.println("�հ� = " + tot);
		for(int i=0 ; i<arr.length ; i++)
			avg = tot/8 ;
		System.out.printf("��� = %d.2 ", avg);
		
		
		for(int j=0 ; j<arr.length ; j++)
			if(arr[j] > maxnum) {
				maxnum = arr[j] ;
				max = j ;
		}
		System.out.println("\n�ִ밪 = " + maxnum);
		
		for(int j=0 ; j<arr.length ; j++)
			if(arr[j] < minnum) {
				minnum = arr[j] ;
				min = j ;
		}
		System.out.println("�ּҰ� = " + minnum);
	}// main
}// class 