package com.pulsha.autotesting.steps;

import com.pulsha.autotesting.driver.DriverSingleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pulsha.autotesting.pages.FinancePage;
import com.pulsha.autotesting.pages.MainPage;

public class Steps
{
	private WebDriver driver;
	
	private static final Logger logger = LogManager.getRootLogger();
	
	private String dollarMainPage;
	
	private String dollarFinancePage;

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}
	
	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		dollarMainPage = mainPage.getDollarCurrency();
		mainPage.clickOnButtonFinance();
	}
		
	public void openFinancePage() {
		FinancePage financePage = new FinancePage(driver);
		financePage.clickOnButtonNBRB();
		dollarFinancePage = financePage.getDollarCurrency();
	}

	public boolean isCurrencyEqual() {
		logger.info("Main page currency: " + dollarMainPage);
		logger.info("Finance page currency: " + dollarFinancePage);
		return dollarMainPage.substring(1).equalsIgnoreCase(dollarFinancePage);
	}

}