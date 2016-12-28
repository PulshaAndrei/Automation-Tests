package com.pulsha.autotesting;

import com.pulsha.autotesting.pages.BuildingsPage;
import com.pulsha.autotesting.pages.MainPage;
import com.pulsha.autotesting.pages.ResoursesPage;
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

	@Test(description = "Finance test")
	public void FinanceTest()
	{
		MainPage mainPage = steps.openMainPage();
		steps.openFinancePage(mainPage);
		Assert.assertTrue(steps.isCurrencyEqual());
	}

	@Test(description = "TV test")
	public void TVTest()
	{
		MainPage mainPage = steps.openMainPage();
		steps.openTVProgramPage(mainPage);
		Assert.assertTrue(steps.checkTVProgramDay());
	}

	@Test(description = "Resourses test")
	public void ResoursesTest()
	{
		MainPage mainPage = steps.openMainPage();
		steps.openResoursesPage(mainPage);
		Assert.assertTrue(steps.checkTitleCatalog());
	}

	@Test(description = "Buildings test")
	public void BuildingsTest()
	{
		steps.openBuildingsPage();
		Assert.assertTrue(steps.checkTitleBuildings());
	}

	@Test(description = "Windows In Minsk test")
	public void WindowsTest()
	{
		BuildingsPage buildingsPage = steps.openBuildingsPage();
		steps.openWindowsPage(buildingsPage);
		Assert.assertTrue(steps.checkTitleWindows());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
