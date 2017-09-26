package br.com.framework_automacao_mobile.driverfactory;

import br.com.framework_automacao_mobile.enumerator.SelectMobile;
import io.appium.java_client.MobileDriver;

public class MobileDriverFactory {

	private MobileDriver driver = null;

	public MobileDriver createDriver(SelectMobile mobile) {

		switch (mobile) {

		case ANDROID:
			if (driver == null) {
				return new Android().getDriver();
			}

		case IOS:
			if (driver == null) {
				return new IOS().getDriver();
			}

		default:
			System.out.printf("Digite as opções de browser: ANDROID ou IOS.");
		}
		
		return driver;
	}

	public MobileDriver getDriver() {
		return driver;
	}

}
