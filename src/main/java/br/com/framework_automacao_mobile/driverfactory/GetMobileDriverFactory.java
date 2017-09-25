package br.com.framework_automacao_mobile.driverfactory;

import org.openqa.selenium.WebDriver;

import br.com.framework_automacao_mobile.enumerator.SelectMobile;


public class GetMobileDriverFactory {

	private static GetMobileDriverFactory instance = new GetMobileDriverFactory();
	private static WebDriver driver = null;

	public WebDriver inicializeDriver(SelectMobile mobile) {
		
		driver = new MobileDriverFactory().createDriver(mobile);
		return driver;
	}

	public static GetMobileDriverFactory getInstance() {
		if (driver == null) {
			instance = new GetMobileDriverFactory();
		}
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
