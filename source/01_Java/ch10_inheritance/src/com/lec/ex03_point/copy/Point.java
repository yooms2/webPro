package com.lec.ex03_point.copy;
// 2����
public class Point {
	private int x;
	private int y;
	public Point() {
		System.out.println("�Ű����� ���� Point(�θ�Ŭ���� = ParentŬ���� = SuperŬ���� = ����Ŭ����) ������");
	}
	public Point(int x, int y) {
		System.out.println("�Ű����� �ִ� Point ������");
		this.x = x;
		this.y = y;
	}
	public String infoPrint() {
		return "��ǥ : x= " + x + ", y= " + y;
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
