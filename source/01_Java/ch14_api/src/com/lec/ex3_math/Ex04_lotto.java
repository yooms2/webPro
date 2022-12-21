package com.lec.ex3_math;

import java.util.Random;

public class Ex04_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do { // �߻��� ������ �ߺ��Ǿ����� üũ
				temp = random.nextInt(45)+1;
				for(j=0 ; j<i ; j++) {
					if(lotto[j] == temp) {
//						System.out.println("�ߺ��Ǽ� �ٽ� ��" + temp);
						break;
					} // if - temp�� ���� ��ȣ�� ������ for���� ��������.
				} //for
			}while(i != j); // i�� j�� �ٸ���(while���� ������ ����) do���� �ݺ�
			lotto[i] = temp;
		}
		// �߻��� �ζ� ��ȣ ���
		for(int l :lotto) {
			System.out.print(l + "\t");
		}
		System.out.println("\n(���� ��)");
		// lotto �迭 ���� sort : 35 17 16 26 15 33
		// i<j       =>        15 16 17 26 33 35
		for(i=0 ; i<lotto.length-1 ; i++) {
			for(j=i+1 ; j<lotto.length ; j++) {
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
			
		}
		for(int l : lotto) { 
			System.out.print(l + "\t");
		}
	} //main

} //class
