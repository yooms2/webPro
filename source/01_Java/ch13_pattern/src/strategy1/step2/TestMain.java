package strategy1.step2;

public class TestMain {
	public static void main(String[] args) {
//		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionRung();
			robot.actionWalk();
			if(robot instanceof SuperRobot) {
				SuperRobot tempRobot = (SuperRobot)robot; // ��ü�� ������� ����ȯ(casting)
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}else if(robot instanceof StandardRobot) {
				StandardRobot tempRobot = (StandardRobot)robot; // ��ü�� ������� ����ȯ(casting)
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}else if(robot instanceof LowRobot) {
				LowRobot tempRobot = (LowRobot)robot; // ��ü�� ������� ����ȯ(casting)
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionKnife();
			}
		}
	}
}
