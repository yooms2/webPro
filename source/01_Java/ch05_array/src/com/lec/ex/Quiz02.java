package com.lec.ex;

public class Quiz02 {
	public static void main(String[] args) {
		int[][] arr = { {5,5,5,5,5}, 
						{10,10,10,10,10}, 
						{20,20,20,20,20}, 
						{30,30,30,30,30} };
		int tot = 0 ;
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[i].length ; j++) {
				System.out.print(arr[i][j]);
				if(i==arr.length-1 && j==arr[i].length-1) {
					System.out.print("=");
				}else {
					System.out.print("+");
				}
				tot += arr[i][j] ;
			}
		}
		System.out.println(tot);
	}
}
