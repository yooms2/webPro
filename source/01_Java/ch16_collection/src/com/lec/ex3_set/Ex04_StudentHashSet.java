package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex04_StudentHashSet {
	public static void main(String[] args) {
		Student s1 = new Student(1, "ȫ�浿");
		Student s2 = new Student(1, "ȫ�浿");
		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		System.out.println(s1.equals(s2));
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(1, "ȫ�浿"));
		students.add(new Student(1, "ȫ�浿"));
		students.add(new Student(3, "�庸��"));
		students.add(new Student(6, "�̼���"));
		students.add(new Student(3, "�ű浿"));
		students.add(new Student(3, "�ű浿"));
		System.out.println(students);
		students.remove(new Student(1, "ȫ�浿"));
		System.out.println("ȫ�浿 remove �� : " + students);
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
