package cucumberpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumberpackage",
glue = "cucumberpackage.stepdefination",
plugin = {"pretty","html:Report/cucumber.html"},
monochrome = true)
public class testrunner extends AbstractTestNGCucumberTests{

}
