package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass ������ ������");
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i�� : " + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("�̱��� ��ü�� i�� ���� �� : " +singletonObject.getI());
	}
}
