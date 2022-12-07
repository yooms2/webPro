package com.lec.quiz;
// 데이터 : 번호, 이름, 국, 영, 수, 총, 평 new Student("정우성", 90, 80, 100); -> 번호, 총점, 평균도 같이 초기화
// 메소드 : infoString(), infoPrint()
public class Student {
	private static int stu;
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int avg;
	public Student() {}
	public Student(String name, int kor, int eng, int mat) {
		no = ++stu;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3; // 버림
		avg = (int)(tot/3.0+0.5); // 반올림
	}
//	public void takenum(int num) {
//		if(stu.num <= num) {
//			stu.num += num;
//		}
//	}
	public String infoString() {
		return String.format("%d\t%s\t%d\t%d\t%d\t%d\t%d\n", no, name, kor, eng, mat, tot, avg);
	}
	public void infoPrint() {
		System.out.printf("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n", no, name, kor, eng, mat, tot, avg);
	}
	public int getNo() {
		return no;
	}
	public void setNo() {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public int getAvg() {
		return avg;
	}
}
