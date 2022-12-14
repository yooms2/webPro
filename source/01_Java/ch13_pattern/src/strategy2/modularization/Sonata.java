package strategy2.modularization;

import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km10;

public class Sonata extends Car {
	
	public Sonata() {
		// engine, km, fuel, setting
		setEngine(new EngineLow());
		setKm(new Km10());
		setFuel(new FuelDiesel());
	}

	@Override
	public void shape() {
		System.out.println("�� �ҳ�Ÿ ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�");
	}

}
