package strategy1.step3;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRung() {
		System.out.println("�� �� �ֽ��ϴ�");
	}
	public void shape() {
		String className = getClass().getName(); // Ŭ���� �̸�("strategy1.step2.SuperRobot")
		int idx = className.lastIndexOf("."); // 15
		String name = className.substring(idx+1); // "SuperRobot"
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�");
	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
