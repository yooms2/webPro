package com.lec.ex;
// ����񱳿�����(���迬����) : ==(����), !=(�ٸ���), >, >=, ....
public class Ex03 {
	public static void main(String[] args) {
		int n1 =10, n2 = 5;
		boolean result;
		result = n1>=n2;
		System.out.printf("%d %s %d �� %b\n", n1, ">=", n2, result);
		result = n1==n2;
		System.out.printf("%d %s %d �� %b\n", n1, "==", n2, result);
		result = n1!=n2;
		System.out.printf("%d %s %d �� %b\n", n1, "!=", n2, result);
		
		result = !(n1!=n2); // ��������(�ݴ븦�ǹ�)
		System.out.printf("!(n1!=n2)��"+ result);
	}
}
