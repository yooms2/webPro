package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "  ja  va2  ";
		System.out.println("1." + str1.concat(str2)); // 1.abcXabcabcXabc
		System.out.println("2." + str1.substring(3)); // 3��°���� ������ : 2.Xabc
		System.out.println("3." + str1.substring(3,5)); // 3��°���� 5��° �ձ��� : 3.Xa
		System.out.println("4." + str1.length()); // ���ڿ� ���� : 4.7
		System.out.println("5." + str1.toUpperCase()); // �빮�ڷ� : 5.ABCXABC
		System.out.println("6." + str1.toLowerCase()); // �ҹ��ڷ� : 6.abcxabc
		System.out.println("7." + str1.charAt(3)); // 3��° ���� : 7.X
		System.out.println("8." + str1.indexOf('b')); // ù��° b�� ������ �ε��� : 8.1
		System.out.println("9." + str1.lastIndexOf("b")); // ������ b�� ������ �ε��� : 9.5
		String str4 = "abcXabcXabcXabc@";
		System.out.println("10." + str4.indexOf("b", 3)); // 3��° �ε������� ������ ù b : 10.5
		System.out.println("11." + str4.indexOf("cXa")); // ó�� ������ cXa�� �ε���
		System.out.println("12." + str4.indexOf("cXa", 9)); // 9��°���� ������ ù cXa : 12.10
		System.out.println("13." + str4.indexOf("z")); // ������ -1 ��� : 13.-1
		System.out.println("14." + str1.equals(str2)); // ���� ��Ʈ���� true : 14.true
		System.out.println("15." + str1.equalsIgnoreCase("abcxabc")); // ��ҹ��� �������� �� : 15.true
		System.out.println("16." + str3.trim()); // �յ�space���� : 16.ja  va2
		System.out.println("17." + str4.replace("abc", "�ٲ�")); // 17.�ٲ�X�ٲ�X�ٲ�X�ٲ�@
		System.out.println("str1=" + str1);
		System.out.println("str3=" + str3);
		System.out.println("str3=" + str3);
		System.out.println("str4=" + str4);
	}
}
