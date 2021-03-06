package br.com.framework_automacao_mobile.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Android {
	
	/**
	 * Documentantion Capabilities: https://appium.io/slate/en/master/?ruby#the-default-capabilities-flag
	 * Documentation ADBShell: http://adbshell.com/
	 */
	
	public AndroidDriver<MobileElement> driver = null; 
    public static AppiumDriverLocalService service = null;

	public AndroidDriver<MobileElement> getDriver() {
		
	    //service = AppiumDriverLocalService.buildDefaultService();
		
		//--caminho da aplicacao que sera testada
		//File arquivoAplicacao = new File("/Users/inmetrics/app/triangulo", "TrianguloApp.apk");
		
		//--capacidades indicando a plataforma, dispositivo e aplicacao
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		//--nao fazer o reset do browser
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
		
		//--seta a aplicacao a ser testada
		//capabilities.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		
		//--Capacidade para executar com Dispositivo Fisico
		//capabilities.setCapability(MobileCapabilityType.UDID, "ORRSOVHU99999999");
		
		//--Capacidade para executar com Emulador
		capabilities.setCapability("avd","Nexus_5X_API_26");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		//--Capacidade para executar aplicativo Calculadora Nativa
		//capabilities.setCapability(MobileCapabilityType.VERSION, "8.0.0");
		//capabilities.setCapability("appPackage", "com.android.calculator2");
		//capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		//capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		//capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		//capabilities.setCapability(MobileCapabilityType.APP, "Calculator.apk");
		
		//service.start();
		//driver = new AndroidDriver<MobileElement>(service, capabilities);
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("ANDROID driver started...");
		
		return driver;
	}


}
