package com.lec.ex;
// Ŭ���� : �Ӽ�, �޼ҵ�, setter&getter 
public class Rect {
	private int width ; 
	private int height ;
	// �����ڰ� ���� ��� JVM�� �ڵ� ����
	public Rect() {} // ����Ʈ ������ �Լ�
	public Rect(int side) {
		width = side ;
		height = side ;
	}
	public Rect(int width, int height) { // �Ű����� 2��¥�� ������
		this.width = width ;
		this.height = height ;
	}
	public int area() {
		return width * height ;
	}
	// getter & setter
	public int getWidth() {
		return width ;
	}
	public void setWidth(int width) {
		this.width = width ;
	}
	public int getHeight() {
		return height ;
	}
	public void setHeight(int height) {
		this.height = height ;
	}
}
