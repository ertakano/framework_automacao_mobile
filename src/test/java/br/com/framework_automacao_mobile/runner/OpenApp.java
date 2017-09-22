package br.com.framework_automacao_mobile.runner;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class OpenApp {
	
	public AndroidDriver<MobileElement> driver;
	
	@Before
	public void beforeTest() throws MalformedURLException {
		
		//caminho da aplicacao que sera testada
		File arquivoAplicacao = new File("/Users/inmetrics/app/triangulo", "TrianguloApp.apk");
		
		
		//capacidades indicando a plataforma, dispositivo e aplicacao
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType.UDID, "ORRSOVHU99999999");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		capabilities.setCapability("avd","Nexus_5X_API_26");
		
		//capabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
		//capabilities.setCapability("appPackage", "com.android.calculator2");
		//capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		//capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		//capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		//capabilities.setCapability(MobileCapabilityType.APP, "Calculator.apk");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
//	@Test
//	public void testeMobile(){
//
//		driver.findElementById("digit_7").click();
//		driver.findElementById("op_mul").click();
//		driver.findElementById("digit_3").click();
//		driver.findElementById("eq").click();
//		
//		String resultado = driver.findElementById("result").getText();
//		
//		Assert.assertEquals("21", resultado);
//	}
	
	@Test
	public void testeTriangulo() {
		
		driver.findElementById("txtLado1").sendKeys("3");
		driver.findElementById("txtLado2").sendKeys("3");
		driver.findElementById("txtLado3").sendKeys("3");
		driver.findElementById("btnCalcular").click();
		
		String resultado = driver.findElementById("txtResultado").getText();
		
		Assert.assertEquals("O triângulo é Equilátero", resultado);
	}
	
	@After
	public void afterTest() {
		driver.closeApp();
		driver.quit();
	}
	
}
