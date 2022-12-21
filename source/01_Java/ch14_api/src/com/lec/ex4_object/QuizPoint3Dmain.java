package com.lec.ex4_object;

public class QuizPoint3Dmain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D[] points = {new Point3D(1,2,3),
							new Point3D(4,5,6),
							new Point3D(7,8,9),
							new Point3D(10,11,12),
							new Point3D(13,14,15),};
		for(Point3D point : points) {
			System.out.println(point);
		}
		// clone
		Point3D p1 = new Point3D();
		p1.setX(2); p1.setY(4); p1.setZ(6);
		Point3D p2 = (Point3D) p1.clone();
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		
		if(p1.equals(p2)) {
			System.out.println("같은 내용");
		}else {
			System.out.println("다른 내용");
		}
		if(p1==p2) {
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");
		}
		if(p1!=p2 && p1.equals(p2)) {
			System.out.println("복제 성공");
		}else {
			System.out.println("복제 실패");
		}
	}
}
