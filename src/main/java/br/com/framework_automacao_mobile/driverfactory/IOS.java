package br.com.framework_automacao_mobile.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class IOS {
	
	public IOSDriver<MobileElement> driver; 

	public WebDriver getDriver() {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		// File file = new File("/MacintoshHD/Applications/Xcode.app");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		
		//--Capacidade para executar com Dispositivo Fisico
		//capability.setCapability(MobileCapabilityType.UDID, "BF352801-4B69-4469-99D0-9F150CE2C61E");
		//capability.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		
		try {
			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capability);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			System.out.println("Appium server and IOS driver started...");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}

}
