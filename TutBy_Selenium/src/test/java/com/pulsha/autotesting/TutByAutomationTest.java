package com.pulsha.autotesting;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pulsha.autotesting.steps.Steps;

public class TutByAutomationTest {
	private Steps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Currency test")
	public void oneCanLoginGithub()
	{
		steps.openMainPage();
		steps.openFinancePage();
		Assert.assertTrue(steps.isCurrencyEqual());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
