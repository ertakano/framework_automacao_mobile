package br.com.framework_automacao_mobile.utils;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class AppiumServerCommand {

	public static void startServer() throws ExecuteException, IOException, InterruptedException {
		
		CommandLine command = new CommandLine("/usr/local/Cellar/node@6/6.11.3/bin/node");
		command.addArgument("/usr/local/lib/node_modules/appium/build/lib/main.js", false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		
		executor.execute(command, resultHandler);
		Thread.sleep(5000);

	}

	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
