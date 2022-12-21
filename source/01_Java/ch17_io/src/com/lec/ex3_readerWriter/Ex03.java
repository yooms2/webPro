package com.lec.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// �����̸��� ������� message�� �ܼ��Է�
public class Ex03 {
	public static void main(String[] args) {
		Writer writer = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("����� ���� �̸���?");
		String filename = scanner.next(); // abc = txtFile/abc.txt
		scanner.nextLine(); // ���� ����� �뵵
		try {
			writer = new FileWriter("txtFile/"+filename+".txt");
			while(true) {
				System.out.print("���Ϸ� ����� �޼����� (����:x):");
				String msg = scanner.nextLine();
				if(msg.equalsIgnoreCase("x"))
					break;
				writer.write(msg + "\n");
			}
			System.out.println("txtFile/"+filename+".txt ���ϸ����� ���� �Ϸ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
