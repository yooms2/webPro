package com.lec.ch01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calculation {
	private int num1;
	private int num2;
	public void add() {
		System.out.println("���ϱ�\t");
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
	}
	public void sub() {
		System.out.println("����\t");
		System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
	}
	public void mul() {
		System.out.println("���ϱ�\t");
		System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
	}
	public void div() {
		System.out.println("������\t");
		System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
	}
}

