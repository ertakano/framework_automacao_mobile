package br.com.framework_automacao_mobile.runner;

import org.junit.runner.RunWith;

import br.com.framework_automacao_mobile.commons.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "features/"
,snippets = SnippetType.CAMELCASE
,glue = "br.com.framework_automacao_mobile.stepdefinitions"
,monochrome = true
,plugin = "br.com.framework_automacao_mobile.report.ExtentCucumberFormatter:"
,tags = {"@CN01,@CN02"}
)

public class CucumberRunner extends TestBase {

}
	