package br.com.framework_automacao_mobile.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.framework_automacao_mobile.driverfactory.GetMobileDriverFactory;
import io.appium.java_client.MobileDriver;

public class MobileDriverUtils{

	private static MobileDriver driver = GetMobileDriverFactory.getInstance().getDriver();
	
	private static long timeout = 20;
	private static WebDriverWait wait = new WebDriverWait(driver, timeout);
	
	public static void awaitsElementToGoAway(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void awaitsElementToGoAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void awaitsElementToGoAppearByName(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
	
	public static void awaitsElementToGoAppearById(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public static void awaitsElementToGoAppearByXpath(String xpath) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public static void switchToFrame (String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public static void switchToDefaultContent () {
		driver.switchTo().defaultContent();
	}
	
	public String getTextByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	protected boolean containsElement(WebElement element) throws Exception {
		try {
			
			MobileDriverUtils.awaitsElementToGoAppear(element);
			if (!element.equals(null)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O elemento: " + element + " não foi encontrado", e);
		}
		return false;
	}
	
	protected boolean containsElementsByText(String text) throws Exception {
		try {
			if (driver.getPageSource().contains(text)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O texto: " + text + " não foi encontrado", e);
		}
		return false;
	}
		
	protected boolean containsTextInElement(WebElement element, String text) throws Exception {
		try {
			MobileDriverUtils.awaitsElementToGoAppear(element);
			if (element.getText().equals(text)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("O texto: " + text + "não foi encontrado", e);
		}
		return false;
	}

	protected boolean isEnabled(WebElement element) {
		MobileDriverUtils.awaitsElementToGoAppear(element);
		return element.isEnabled();
	}
	
	protected void click(WebElement element) {
		MobileDriverUtils.awaitsElementToGoAppear(element);
		element.click();
	}

	protected void clear(WebElement element) {
		MobileDriverUtils.awaitsElementToGoAppear(element);
		element.clear();
	}
	
	protected void writeText(WebElement element, String text) {
		clear(element);
		element.sendKeys(text);
	}
	
	protected void selectElementListBox(WebElement element, String itemValue) {
		MobileDriverUtils.awaitsElementToGoAppear(element);
		new Select(element).selectByVisibleText(itemValue);
	}

	protected void navigateTo(String url) {
		driver.navigate().to(url);
	}
		
	public void alterTab() {
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			}
	}
	
	public void returnAlterTab() {
		for(String winHandleBefore : driver.getWindowHandles()){
		    driver.switchTo().window(winHandleBefore);
		}
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
}
