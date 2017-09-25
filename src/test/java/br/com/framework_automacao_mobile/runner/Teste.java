package br.com.framework_automacao_mobile.runner;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Teste {

	private static IOSDriver driver;

	@Test
	public void main() throws IOException {
		// TODO Auto-generated method stub
		startServer();
		DesiredCapabilities capability = new DesiredCapabilities();
		// File file = new File("/MacintoshHD/Applications/Xcode.app");
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		capability.setCapability(MobileCapabilityType.UDID, "BF352801-4B69-4469-99D0-9F150CE2C61E");
		// capability.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		// driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver = new IOSDriver(capability);
		driver.close();
		stopServer();
	}

	public static void startServer() {

		CommandLine command = new CommandLine("/usr/local/bin/node");
		command.addArgument("/usr/local/lib/node_modules/appium/build/lib/appium.js", false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--full-reset", false);
		command.addArgument("wd");
		command.addArgument("hub");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
