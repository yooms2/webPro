package com.lec.quiz;

public class Main {
	public static void main(String[] args) {
		Person st1 = new Student("student1","A01","������","JAVA��");
		Person st2 = new Student("student2","A02","ȫ�浿","C++��");
		Person sf1 = new Staff("staff1","S01","���浿","�������");
		Person sf2 = new Staff("staff2","S01","���浿","���������");
		Person ga1 = new Gangsa("lecturer1","G01","�̱浿","��ü����");
		Person[] p = {st1, st2, sf1, sf2, ga1};
		for(Person pp : p)
			System.out.println(pp.infoString());
	}
}
