package com.lec.ex4_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;
	public Point3D() {}
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) {
			Point3D other = (Point3D)obj;
			boolean xCk = x == other.x; 
			boolean yCk = y == other.y; 
			boolean zCk = z == other.z;
			
			return xCk && yCk && zCk;
		}
		return false;	
	}
	@Override
	public String toString() {
//		return String.format("x=%d, y=%d, z=%d", x ,y ,z);
		return "[x]:" + x + " [y]:" + y + " [z]:" +z;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
}

