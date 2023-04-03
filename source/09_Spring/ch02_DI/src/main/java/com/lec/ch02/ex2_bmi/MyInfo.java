package com.lec.ch02.ex2_bmi;

import java.util.ArrayList;

import lombok.Data;
@Data
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMICalculator bmiCalculator;
	public void infoPrint() {
		System.out.println("�̸� : " + name);
		System.out.println("Ű : " + height);
		System.out.println("ü�� : " + weight);
		System.out.println("��� : " + hobby);
		bmiCalculator.bmiCalculation(weight, height);
		System.out.println("-----------------------------");
	}
}
