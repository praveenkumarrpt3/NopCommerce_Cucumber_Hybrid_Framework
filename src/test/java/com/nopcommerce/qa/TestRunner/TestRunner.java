package com.nopcommerce.qa.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\SunLand\\Desktop\\Welcome\\Bdd_Cucummber_NopCommerce\\src\\test\\resources\\Features\\",
glue= {"com.nopcommerce.qa.StepDefinations","com.nopcommerce.qa.hooks"},
dryRun=!true, 
monochrome=true,
plugin= {"pretty","html:target/cucumber-reports.html"})

public class TestRunner {

	
	
}


