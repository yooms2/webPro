package com.lec.ex8_decimal;

import java.util.Random;
import java.util.Scanner;
//you��  �̱涧���� �ݺ�
public class quiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int you, computer;
		do{
			computer = random.nextInt(3);
			System.out.println("����,����,�� �� �ϳ��� �����ϼ���");
			String youStr = scanner.next().trim();

			String computerStr = (computer==0) ? "����" : (computer==1)?"����":"���ڱ�";
			if(youStr.equals("����")) {
				you = 0;
			}else if(youStr.equals("����")) {
				you = 1;
			}else if(youStr.equals("��")) {
				you = 2;
			}else {
				you=-1;
				continue;
			}
			if( (you+2)%3 == computer ) {
				System.out.printf("����� %s, ��ǻ�ʹ� %s. ����� �̰��� ^.^\n", youStr, computerStr);
			}else if((you+1)%3 == computer){
				System.out.printf("����� %s, ��ǻ�ʹ� %s. ��ǻ�Ͱ� �̰��� ��.��\n", youStr, computerStr);
			}else {
				System.out.printf("����� %s, ��ǻ�ʹ� %s. �����\n",  youStr, computerStr);
			}
		}while(you==-1 || (you+1)%3 == computer || you==computer);//do~while
		scanner.close();
		System.out.println("YOU WIN \n -BYE-");
	}//main
}//class
