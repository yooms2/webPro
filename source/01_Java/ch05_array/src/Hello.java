// javac.exe Hello.jva
// java.exe Hello �� RM ���� ��
public class Hello {
	public static void main(String[] args) { // args�� �迭�� ���� -- �� RM ���� ��(�迭 �� ���� 4��)
		System.out.print("Hello");
		for(int i=0 ; i<args.length ; i++) {
			System.out.print(", " + args[i]);
		}
	}

}
