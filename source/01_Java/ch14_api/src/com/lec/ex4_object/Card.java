package com.lec.ex4_object;
// new Card('��',6);
public class Card {
	private char kind; // ��, ��, ��, ��
	private int num; // 1 ~ 13
	public Card() {}
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() { // prinln() �ȿ� �ڵ����� ���� ��
		return "ī�� : " + kind + " " + num; // ī�� : �� 5
	}
	@Override
	public boolean equals(Object obj) {
		// card.equals(comCard) => card�� this. comCard�� obj
		// obj�� null�� �ƴϰ� obj�� CardŸ�� ��ü���� Ȯ�� ��, kind�� num �� ��� return
		if(obj != null && getClass()==obj.getClass()) { // if(obj!=null && obj instanceof Card)
			// kind�� num �� ��� return
			Card other = (Card)obj;
			boolean kindChk = kind == other.kind; // kind.equals(other.kind)
			boolean numChk = num == other.num;
			
			return kindChk && numChk;
		}
		return super.equals(obj);
	}
}
