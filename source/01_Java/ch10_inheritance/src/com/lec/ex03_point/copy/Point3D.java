package com.lec.ex03_point.copy;
// x, y / infoPrint(��ǥ x=2, y=1�� �ֿܼ� ���)
public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x, y);
		System.out.println("�Ű����� �ִ� Point3D ������ �Լ� - x, y, z �� �ʱ�ȭ");
//		setX(x); // this.x = x;
//		setY(y);
		this.z = z;
	}
	public String infoPrint() {
		return super.infoPrint() + ", z=" + z;
	}
	// infoPrint�� ȿ������ overrid : ��ǥ x=2, y=1, z=1 (super.infoPrint�̿�)
//	public void infoPrint3d() {
//		System.out.println("��ǥ x = " + getX() + ", y = " + getY() + ", z = " + z);
//	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
