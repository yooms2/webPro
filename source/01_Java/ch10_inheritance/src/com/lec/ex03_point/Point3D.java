package com.lec.ex03_point;
// x, y / infoPrint(��ǥ x=2, y=1�� �ֿܼ� ���)
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		System.out.println("�Ű����� �ִ� Poing3D ������ �Լ� - x, y, z �� �ʱ�ȭ");
		setX(x); // this.x = x;
		setY(y);
		this.z = z;
	}
	public void infoPrint3d() {
		System.out.println("��ǥ x = " + getX() + ", y = " + getY() + ", z = " + z);
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
