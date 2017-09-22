package br.com.framework_automacao_mobile.driverfactory;

import org.openqa.selenium.WebDriver;

import br.com.framework_automacao_mobile.enumerator.SelectMobile;

public class MobileDriverFactory {

	private WebDriver driver = null;

	public WebDriver createDriver(SelectMobile mobile) {

		switch (mobile) {

		case ANDROID:
			if (driver == null) {
				driver = new Android().getDriver();
			}
			break;

		case IOS:
			if (driver == null) {
				driver = new IOS().getDriver();
			}
			break;

		default:
			System.out.printf("Digite as opções de browser: ANDROID ou IOS.");
		}

		return driver;

	}

	public WebDriver getDriver() {
		return driver;
	}

}
