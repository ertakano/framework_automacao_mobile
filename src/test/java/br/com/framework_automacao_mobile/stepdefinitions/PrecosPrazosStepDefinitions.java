package br.com.framework_automacao_mobile.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.framework_automacao_default.pagefactory.HomePageObject;
import br.com.framework_automacao_default.pagefactory.PrecosEPrazosPageObject;
import br.com.framework_automacao_mobile.driverfactory.GetMobileDriverFactory;
import br.com.framework_automacao_mobile.report.ExtentCucumberFormatter;
import br.com.framework_automacao_mobile.utils.WebDriverUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PrecosPrazosStepDefinitions{

	private static WebDriver driver = GetMobileDriverFactory.getInstance().getDriver();
	
	WebDriverUtils utils = new WebDriverUtils();
	HomePageObject home;
	PrecosEPrazosPageObject precosPrazos;
	
	@Before()
	public void irHome() throws IOException {
		
		//Inicializa os elementos da pagina de Home dos Correios da PageFactory
		home = PageFactory.initElements(driver, HomePageObject.class);
		home.goToHome();
	}
	
	@Dado("^que eu esteja na home dos correios$")
	public void queEuEstejaNaHomeDosCorreios() throws Throwable {
		Assert.assertTrue(home.isValida());
		ExtentCucumberFormatter.screenShot("home dos correios");
		ExtentCucumberFormatter.insertInfoTextInStepReport("Acessa a tela inicial dos correios");
	}

	@Dado("^que estou na tela inicial da tela de Precos e prazos$")
	public void queEstouNaTelaInicialDaTelaDePrecosePrazos() throws Throwable {
		
		//Inicializa os elementos da pagina de Precos e Prazos da PageFactory
		precosPrazos = PageFactory.initElements(driver, PrecosEPrazosPageObject.class);	
		precosPrazos.clicarBotaoPrecosPrazos();
		
		driver.getPageSource();
		
		Assert.assertEquals(precosPrazos.namePagePrecosPrazos(), "Sistemas");
		ExtentCucumberFormatter.screenShot("tela de Precos e prazos");
		ExtentCucumberFormatter.insertInfoTextInStepReport("Acessa a tela de precos e prazos");
	}

	@Dado("^que eu insira a Data de Postagem$")
	public void queEuInsiraADataDePostagem() throws Throwable {
		precosPrazos.preencherDataDePostagem();
		ExtentCucumberFormatter.screenShot("Data de Postagem");
		ExtentCucumberFormatter.insertInfoTextInStepReport("Insere a data de postagem");
	}

	@Dado("^que eu insira o CEP de origem \"(.*?)\"$")
	public void queEuInsiraOCEPDeOrigem(String cepOrigem) throws Throwable {
		precosPrazos.preencherCepDeOrigem(cepOrigem);
		ExtentCucumberFormatter.screenShot("CEP de origem");
	}
	
	@Dado("^que eu insira o CEP de destino \"(.*?)\"$")
	public void queEuInsiraOCEPDeDestino(String cepDestino) throws Throwable {
		precosPrazos.preencherCepDeDestino(cepDestino);
		ExtentCucumberFormatter.screenShot("CEP de destino");
	}
	
	@Dado("^selecione o Tipo de Servico \"(.*?)\"$")
	public void selecioneOTipoDeServico(String tipoServico) throws Throwable {
		precosPrazos.selecionarTipoServico(tipoServico);
		ExtentCucumberFormatter.screenShot("Tipo de Servico");
	}

	@Quando("^clicar em Enviar$")
	public void clicarEmEnviar() throws Throwable {
		precosPrazos.clicarBotaoEnviar();
		ExtentCucumberFormatter.screenShot("Enviar");
	}

	@Entao("^devo visualizar os dados Prazo de entrega \"(.*?)\", entrega \"(.*?)\", Dias de Entrega \"(.*?)\"$")
	public void devoVisualizarOsDadosPrazoDeEntregaEntregaDiasDeEntrega(String prazoEntrega, String entrega, String diasEntrega) throws Throwable {
		utils.alterTab();
		Assert.assertEquals(prazoEntrega, precosPrazos.pegarTextoprazoEntregaTxt());
		Assert.assertEquals(entrega, precosPrazos.pegarTextoentregaTxt());
		Assert.assertEquals(diasEntrega, precosPrazos.pegarTextodiasEntregaTxt());
		ExtentCucumberFormatter.screenShot("dados Prazo de entrega");
	}

	@Entao("^clicar em dados do Objeto Simulado$")
	public void clicarEmDadosDoObjetoSimulado() throws Throwable {
		try {
			precosPrazos.clicarBotaoDadosObjetoSimulado();
			ExtentCucumberFormatter.screenShot("Objeto Simulado");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Entao("^o endereco Simulado de Origem: CEP \"(.*?)\", endereco \"(.*?)\", Bairro \"(.*?)\", Cidade / UF \"(.*?)\"$")
	public void oEnderecoSimuladoDeOrigemCEPEnderecoBairroCidadeUF(String CEPOrigem, String enderecoOrigem, String bairroOrigem, String cidadeUfOrigem) throws Throwable {
		Assert.assertEquals(CEPOrigem, precosPrazos.pegarcepOrigemTxt());
		Assert.assertEquals(enderecoOrigem, precosPrazos.pegarendOrigemTxt());
		Assert.assertEquals(bairroOrigem, precosPrazos.pegarbairroOrigemTxt());
		Assert.assertEquals(cidadeUfOrigem, precosPrazos.pegarcidadeOrigemTxt());
		ExtentCucumberFormatter.screenShot("endereco Simulado de Origem");
	}
	
	@Entao("^o endereco Simulado de Destino: CEP \"(.*?)\", endereco \"(.*?)\", Bairro \"(.*?)\", Cidade / UF \"(.*?)\"$")
	public void oEnderecoSimuladoDeDestinoCEPEnderecoBairroCidadeUF(String CEPDestino, String enderecoDestino, String bairroDestino, String cidadeUfDestino) throws Throwable {
		Assert.assertEquals(CEPDestino, precosPrazos.pegarcepDestinoTxt());
		Assert.assertEquals(enderecoDestino, precosPrazos.pegarendDestinoTxt());
		Assert.assertEquals(bairroDestino, precosPrazos.pegarbairroDestinoTxt());
		Assert.assertEquals(cidadeUfDestino, precosPrazos.pegarcidadeDestinoTxt());
		ExtentCucumberFormatter.screenShot("endereco Simulado de Destino");
	}
	
	@SuppressWarnings("static-access")
	@Entao("^o endereco Simulado de Origem: CEP, endereco, Bairro, Cidade$")
	public void oEnderecoSimuladoDeOrigemCEPEnderecoBairroCidade(List<String> listaEnderecoOrigem) throws Throwable {

		String cep = null;
		String endereco = null;
		String Bairro = null;
		String Cidade = null;
		
		for(String lista : listaEnderecoOrigem) {
			cep = lista.valueOf(precosPrazos.pegarcepOrigemTxt());
			endereco = lista.valueOf(precosPrazos.pegarendOrigemTxt());
			Bairro = lista.valueOf(precosPrazos.pegarbairroOrigemTxt());
			Cidade = lista.valueOf(precosPrazos.pegarcidadeOrigemTxt());
		}
		
		Assert.assertEquals(cep, precosPrazos.pegarcepOrigemTxt());
		Assert.assertEquals(endereco, precosPrazos.pegarendOrigemTxt());
		Assert.assertEquals(Bairro, precosPrazos.pegarbairroOrigemTxt());
		Assert.assertEquals(Cidade, precosPrazos.pegarcidadeOrigemTxt());
		ExtentCucumberFormatter.screenShot("endereco Simulado de Origem");
	}
	
	@SuppressWarnings("static-access")
	@Entao("^o endereco Simulado de Destino: CEP, endereco, Bairro, Cidade$")
	public void oEnderecoSimuladoDeDestinoCEPEnderecoBairroCidade(List<String> listaEnderecoDestino) throws Throwable {
		
		String CEPDestino = null;
		String enderecoDestino = null;
		String bairroDestino = null;
		String cidadeUfDestino = null;
		
		for(String lista : listaEnderecoDestino) {
			CEPDestino = lista.valueOf(precosPrazos.pegarcepDestinoTxt());
			enderecoDestino = lista.valueOf(precosPrazos.pegarendDestinoTxt());
			bairroDestino = lista.valueOf(precosPrazos.pegarbairroDestinoTxt());
			cidadeUfDestino = lista.valueOf(precosPrazos.pegarcidadeDestinoTxt());
		}
		
		Assert.assertEquals(CEPDestino, precosPrazos.pegarcepDestinoTxt());
		Assert.assertEquals(enderecoDestino, precosPrazos.pegarendDestinoTxt());
		Assert.assertEquals(bairroDestino, precosPrazos.pegarbairroDestinoTxt());
		Assert.assertEquals(cidadeUfDestino, precosPrazos.pegarcidadeDestinoTxt());
		ExtentCucumberFormatter.screenShot("endereco Simulado de Destino");
	}
	
	@After()
	public void retornarTabEfecharAba() {
		driver.close();
		utils.returnAlterTab();
	}

}
