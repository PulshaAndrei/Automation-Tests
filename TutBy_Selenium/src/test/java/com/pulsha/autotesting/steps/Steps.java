package com.pulsha.autotesting.steps;

import com.pulsha.autotesting.driver.DriverSingleton;

import com.pulsha.autotesting.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

public class Steps
{
	private WebDriver driver;
	private static final Logger logger = LogManager.getRootLogger();

	private String dollarMainPage;
	private String dollarFinancePage;
	private int tvPageDay;
	private String allResoursesTitle;
    private String buildingsTitle;
    private String windowsTitle;

    public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}
	public void closeDriver()
	{
		driver.quit();
	}
	
	public MainPage openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		dollarMainPage = mainPage.getDollarCurrency();
		return mainPage;
	}
		
	public void openFinancePage(MainPage mainPage) {
		mainPage.clickOnButtonFinance();
		FinancePage financePage = new FinancePage(driver);
		financePage.clickOnButtonNBRB();
		dollarFinancePage = financePage.getDollarCurrency();
	}

	public void openTVProgramPage(MainPage mainPage) {
		mainPage.clickOnButtonTVPage();
		TVPage tvPage = new TVPage(driver);
		tvPageDay = tvPage.getDay();
	}

	public ResoursesPage openResoursesPage(MainPage mainPage) {
		mainPage.clickOnButtonResourses();
		mainPage.clickOnButtonAllResourses();
		ResoursesPage resoursesPage = new ResoursesPage(driver);
		allResoursesTitle = resoursesPage.getTitle();
		return resoursesPage;
	}

	public BuildingsPage openBuildingsPage() {
        BuildingsPage buildingsPage = new BuildingsPage(driver);
        buildingsPage.openPage();
        buildingsTitle = buildingsPage.getTitle();
        return buildingsPage;
	}

    public void openWindowsPage(BuildingsPage buildingsPage) {
        buildingsPage.clickOnButtonWindows();
        WindowsPage windowsPage = new WindowsPage(driver);
        windowsTitle = windowsPage.getTitle();
    }

	public boolean isCurrencyEqual() {
		logger.info("Main page currency: " + dollarMainPage);
		logger.info("Finance page currency: " + dollarFinancePage);
		return dollarMainPage.substring(1).equalsIgnoreCase(dollarFinancePage);
	}

	public boolean checkTVProgramDay() {
		Calendar calendar = Calendar.getInstance();
		return tvPageDay == calendar.get(Calendar.DAY_OF_MONTH);
	}

	public boolean checkTitleCatalog() {
		return allResoursesTitle.equalsIgnoreCase("Разделы портала");
	}

    public boolean checkTitleBuildings() {
        return buildingsTitle.equalsIgnoreCase("Все для строительства и ремонта в Минске");
    }

    public boolean checkTitleWindows() {
        logger.info(windowsTitle);
        return windowsTitle.equalsIgnoreCase("Минске");
    }
}