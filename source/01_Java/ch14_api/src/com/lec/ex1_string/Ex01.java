package com.lec.ex1_string;
// new�����ڸ� ������� �ʰ� ""�� ����� ���ڿ� ��� heap ������ String ��ü ������
// �̹� �����ϴ� ���ڿ� ����� ����Ѵٸ�, �̹� ������ ���ڿ��� �����Ѵ�
public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "Java";
		String str2 = "Java";
		String str3 = new String("Java");
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҸ� ����");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҸ� ����");
		}
		System.out.println(str1==str3 ? "str1�� str3�� ���� �ּ�" : "str1�� str3�� �ٸ� �ּ�");
		str2 = "Java~";
		System.out.println(str1==str2 ? "������ ���� �ּ� ����" : "������ �ٸ� �ּ� ����");
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
	}
}
