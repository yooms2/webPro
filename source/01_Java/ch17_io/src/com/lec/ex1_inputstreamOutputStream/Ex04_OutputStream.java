package com.lec.ex1_inputstreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // (1)
			String msg = "Hello, Java \n ���� ��׿�. ������ �Ͱ� �Ǽ���";
			byte[] bs = msg.getBytes(); // ��Ʈ���� byte�迭�� �ٲٴ� �Լ�
			os.write(bs); // (2)
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println("���� ���� : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			try {
				if(os!=null) os.close(); // (3)
			} catch (IOException ignore) {}
		}
	}
}
