package com.lec.condition;
import java.util.Scanner;
// �����Ҷ����� ��ǻ�Ͱ� ����(����)���� �߻��Ͽ� ���� ���
public class Ex07_switch_Randomhakjum {
	public static void main(String[] args) {
		// 0 <= Math.random() < 1 : �Ǽ�
		// 0 <= Math.random()*101 < 101 : �Ǽ�
		// 0 <= (int)(Math.random()*101) < 101 : ���� 
//		System.out.println((int)(Math.random()*100));
		int score = (int)(Math.random()*101);
		int temp = (score == 100) ? score-1 : score;
		switch(temp/10) {
		case 9:
			System.out.println(score + ", A����");break;
		case 8:
			System.out.println(score + ", B����");break;
		case 7:
			System.out.println(score + ", C����");break;
		case 6:
			System.out.println(score + ", D����");break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println(score + ", F����");break;
		default:
			System.out.println(score + ", ��ȿ���� �ʴ� �����Դϴ�");
		}
//		int score = sc.nextInt();
//		int temp = (score == 100) ? score-1 : score;
//		switch(temp/10) {
//		case 9:
//			System.out.println("A����");break;
//		case 8:
//			System.out.println("B����");break;
//		case 7:
//			System.out.println("C����");break;
//		case 6:
//			System.out.println("D����");break;
//		case 5: case 4: case 3: case 2: case 1: case 0: 
//			System.out.println("F����");break;
//		default :
//			System.out.println("��ȿ���� �ʴ� �����Դϴ�");
//		}
	}

}
