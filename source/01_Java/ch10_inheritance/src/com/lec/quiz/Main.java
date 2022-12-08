package com.lec.quiz;

public class Main {
	public static void main(String[] args) {
		Person st1 = new Student("student1","A01","강유미","JAVA반");
		Person st2 = new Student("student2","A02","홍길동","C++반");
		Person sf1 = new Staff("staff1","S01","유길동","운영지원팀");
		Person sf2 = new Staff("staff2","S01","유길동","취업지원팀");
		Person ga1 = new Gangsa("lecturer1","G01","이길동","객체지향");
		Person[] p = {st1, st2, sf1, sf2, ga1};
		for(Person pp : p)
			System.out.println(pp.infoString());
	}
}
