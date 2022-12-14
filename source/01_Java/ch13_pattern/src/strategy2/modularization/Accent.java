package strategy2.modularization;

import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km15;

public class Accent extends Car {
	
	public Accent() {
		// engine, km, fuel, setting
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.println("�� ����Ʈ ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�");
	}

}
