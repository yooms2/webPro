package com.lec.ex1_list;

import java.util.Vector;

public class Ex03_vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add(new A()); // 0�� �ε���
		vec.add(new B()); // 1�� �ε���
		vec.add("Hello, Collection"); // 2�� �ε���
		vec.add(10); // 3���ε��� new Interger(10)
		System.out.println(vec);
	}
}
