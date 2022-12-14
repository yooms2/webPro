package strategy2.modularization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km20;

public class Genesis extends Car {
	
	public Genesis() {
		// engine, km, fuel, setting
		setEngine(new EngineHigh());
		setKm(new Km20());
		setFuel(new FuelGasoline());
	}

	@Override
	public void shape() {
		System.out.println("�� ���׽ý� ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�");
	}

}
