package com.lec.ex03_point;
// 2����
public class Point {
	private int x;
	private int y;
	public Point() {
		System.out.println("�Ű����� ���� Point(�θ�Ŭ����=PrentŬ����=SuperŬ����=����Ŭ����) ������");
	}
	public Point(int x, int y) {
		System.out.println("�Ű����� �ִ� Point ������");
		this.x = x;
		this.y = y;
	}
	public void infoPrint() {
		System.out.println("��ǥ : x= " + x + ", y= " + y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
