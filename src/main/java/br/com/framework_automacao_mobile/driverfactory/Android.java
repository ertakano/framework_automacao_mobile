package br.com.framework_automacao_mobile.driverfactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Android {
	
	/**
	 * Documentantion Capabilities: https://appium.io/slate/en/master/?ruby#the-default-capabilities-flag
	 * Documentation ADBShell: http://adbshell.com/
	 */
	
	public WebDriver driver; 
	public String URL_Server = "http://127.0.0.1:4723/wd/hub";

	public WebDriver getDriver() {
		
		//--caminho da aplicacao que sera testada
		//File arquivoAplicacao = new File("/Users/inmetrics/app/triangulo", "TrianguloApp.apk");
		
		//--capacidades indicando a plataforma, dispositivo e aplicacao
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		//--seta a aplicacao a ser testada
		//capabilities.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		
		//--Capacidade para executar com Dispositivo Fisico
		//capabilities.setCapability(MobileCapabilityType.UDID, "ORRSOVHU99999999");
		
		//--Capacidade para executar com Emulador
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		capabilities.setCapability("avd","Nexus_5X_API_26");
		
		//--Capacidade para executar aplicativo Calculadora Nativa
		//capabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
		//capabilities.setCapability("appPackage", "com.android.calculator2");
		//capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		//capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		//capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		//capabilities.setCapability(MobileCapabilityType.APP, "Calculator.apk");
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL(URL_Server), capabilities);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			System.out.println("Appium server and ANDROID driver started...");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}


}
