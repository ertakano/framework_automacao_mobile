package br.com.framework_automacao_mobile.driverfactory;

import br.com.framework_automacao_mobile.enumerator.SelectMobile;
import io.appium.java_client.MobileDriver;


public class GetMobileDriverFactory {

	private static GetMobileDriverFactory instance = new GetMobileDriverFactory();
	private static MobileDriver driver = null;
	
	public MobileDriver inicializeDriver(SelectMobile mobile) {
		
		driver = new MobileDriverFactory().createDriver(mobile);
		return driver;
	}

	public static GetMobileDriverFactory getInstance() {
		if (driver == null) {
			instance = new GetMobileDriverFactory();
		}
		return instance;
	}

	public MobileDriver getDriver() {
		return driver;
	}
}
