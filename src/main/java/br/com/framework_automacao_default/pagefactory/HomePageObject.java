package br.com.framework_automacao_default.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.framework_automacao_mobile.driverfactory.GetMobileDriverFactory;
import br.com.framework_automacao_mobile.utils.MobileDriverUtils;
import io.appium.java_client.MobileDriver;

public class HomePageObject extends MobileDriverUtils{

	private MobileDriver driver = GetMobileDriverFactory.getInstance().getDriver();
	
	private String url = "http://www.correios.com.br/para-voce";

	@FindBy(id = "portaltab-para-voce")
	private WebElement idButtonVoce;
	
	public void goToHome() {
		driver.navigate().to(url);
	}
	
	/**
	 * Valida se os componentes de validação da tela estão presentes
	 * @return
	 * @throws Exception 
	 */
	public boolean isValida() throws Exception {
		//WebElement idButtonVoce = driver.findElement(By.id("portaltab-para-voce"));
		return containsElement(idButtonVoce);
	}
	
}
