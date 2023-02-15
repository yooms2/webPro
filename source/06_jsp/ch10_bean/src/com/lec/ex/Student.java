package com.lec.ex;

public class Student {
	private String hak;
	private String name;
	private int grade;
	private char ban;
	private int score;
	public Student() {}
	public Student(String hak, String name, int grade, char ban, int score) {
		this.hak = hak;
		this.name = name;
		this.grade = grade;
		this.ban = ban;
		this.score = score;
	}
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getBan() {
		return ban;
	}
	public void setBan(char ban) {
		this.ban = ban;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
