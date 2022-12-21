package com.lec.ex1_inputstreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// ������ ���� -> ���� - > ������ �ݴ´�
public class Ex03_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // true : append
			byte[] bs = {'H', 'e', 'l', 'l', 'o', ' ', 'C', '+', '+'};
//			for(byte b : bs) {
//				os.write(b); // 2. ������ write�Ѵ�
//			}
			os.write(bs);
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
