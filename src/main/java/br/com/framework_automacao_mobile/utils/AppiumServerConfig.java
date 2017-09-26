package br.com.framework_automacao_mobile.utils;

import java.io.File;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;

public class AppiumServerConfig {
	
	static AppiumServer appiumServer;

	public static void startServer() {
		
		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--address", "127.0.0.1");
		serverArguments.setArgument("--port", "4723");
		serverArguments.setArgument("--no-reset", true);
		serverArguments.setArgument("--local-timezone", true);
		
		File fileNode = new File("/usr/local/Cellar/node@6/6.11.3/bin/node");
		File fileJS = new File("/usr/local/lib/node_modules/appium/build/lib/main.js"); 
		
		appiumServer = new AppiumServer(fileNode,fileJS,serverArguments);
		appiumServer.startServer();
		System.out.println("Appium server started...");
	}

	public static void stopServer() {
		appiumServer.stopServer();
		System.out.println("Appium server stopped...");
	}
}
