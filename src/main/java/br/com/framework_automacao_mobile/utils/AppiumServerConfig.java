package br.com.framework_automacao_mobile.utils;

import java.io.File;
import java.io.IOException;

import com.github.genium_framework.server.ServerArguments;
import com.github.genium_framework.appium.support.server.arguments.*;
import com.github.genium_framework.appium.support.server.*;

public class AppiumServerConfig {
	
	static AppiumServer appiumServer;

	public static void startServer() {
		
		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--address", "127.0.0.1");
		serverArguments.setArgument("--port", "4723");
		serverArguments.setArgument("--no-reset", true);
		serverArguments.setArgument("--local-timezone", true);
		
		File fileNode = new File("/usr/local/bin/node");
		File fileJS = new File("/usr/local/lib/node_modules/appium/build/lib/appium.js"); 
		
		appiumServer = new AppiumServer(fileNode,fileJS,serverArguments);
		appiumServer.startServer();
		System.out.println("Appium server started...");
	}

	public static void stopServer() {
		appiumServer.stopServer();
		System.out.println("Appium server stopped...");
	}
}
