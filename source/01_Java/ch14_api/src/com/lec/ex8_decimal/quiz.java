package com.lec.ex8_decimal;

import java.util.Random;
import java.util.Scanner;
//you가  이길때까지 반복
public class quiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int you, computer;
		do{
			computer = random.nextInt(3);
			System.out.println("가위,바위,보 중 하나를 선택하세요");
			String youStr = scanner.next().trim();

			String computerStr = (computer==0) ? "가위" : (computer==1)?"바위":"보자기";
			if(youStr.equals("가위")) {
				you = 0;
			}else if(youStr.equals("바위")) {
				you = 1;
			}else if(youStr.equals("보")) {
				you = 2;
			}else {
				you=-1;
				continue;
			}
			if( (you+2)%3 == computer ) {
				System.out.printf("당신은 %s, 컴퓨터는 %s. 당신이 이겼어요 ^.^\n", youStr, computerStr);
			}else if((you+1)%3 == computer){
				System.out.printf("당신은 %s, 컴퓨터는 %s. 컴퓨터가 이겼어요 ㅠ.ㅠ\n", youStr, computerStr);
			}else {
				System.out.printf("당신은 %s, 컴퓨터는 %s. 비겼어요\n",  youStr, computerStr);
			}
		}while(you==-1 || (you+1)%3 == computer || you==computer);//do~while
		scanner.close();
		System.out.println("YOU WIN \n -BYE-");
	}//main
}//class
