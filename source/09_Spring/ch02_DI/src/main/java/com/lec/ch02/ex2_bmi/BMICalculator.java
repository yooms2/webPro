package com.lec.ch02.ex2_bmi;

import lombok.Data;

@Data
public class BMICalculator {
	private double lowWeight; // ��ü�� bmi ���� ������
	private double normal; // ����ü�� bmi ���� ������
	private double overWeight; // ��ü�� ������
	private double obesity; // �� ������
	public void bmiCalculation(double weight, double height) {
		// 60, 175.1 => 60/(1.751*1.75)
		double h = height*0.01;
		double result = weight / (h * h);
		System.out.println("BMI������ " + result);
		if(result <= lowWeight) {
			System.out.println("��ü���Դϴ�");
		} else if(result < normal) {
			System.out.println("����ü���Դϴ�");
		} else if(result < overWeight) {
			System.out.println("��ü���Դϴ�");
		} else if(result < obesity) {
			System.out.println("1�ܰ� ���Դϴ�");
		} else {
			System.out.println("2�ܰ� ���Դϴ�");
		}
	}
}
