package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// outputStream�� ����(���� ������ ��Ʈ��)
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null; // �⺻ ��Ʈ��
		DataOutputStream dos = null; // ���� ��Ʈ��
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("ȫ�浿"); // ��Ʈ�� ����
			dos.writeInt(2); // int ����
			dos.writeDouble(95.5); // double �� ����
			
			dos.writeUTF("���浿"); // ��Ʈ�� ����
			dos.writeInt(6); // int ����
			dos.writeDouble(97.2); // double �� ����
			System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã�� : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
