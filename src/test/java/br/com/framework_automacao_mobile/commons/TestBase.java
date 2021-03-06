package br.com.framework_automacao_mobile.commons;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.framework_automacao_mobile.driverfactory.GetMobileDriverFactory;
import br.com.framework_automacao_mobile.enumerator.SelectMobile;
import br.com.framework_automacao_mobile.utils.AppiumServerCommand;
import io.appium.java_client.MobileDriver;

public class TestBase{
	
	private static MobileDriver driver = null;
	
	@BeforeClass
	public static void getDriver() throws IOException, InterruptedException {
		
		AppiumServerCommand.startServer();
		GetMobileDriverFactory.getInstance().inicializeDriver(SelectMobile.ANDROID);
		driver = GetMobileDriverFactory.getInstance().getDriver();
		System.out.println("Inicializando AndroidDriver...");
	}

	@AfterClass
	public static void closeDriver() {
		
		System.out.println("Fechando AndroidDriver....");
		driver.close();
		AppiumServerCommand.stopServer();
	}

	
}
