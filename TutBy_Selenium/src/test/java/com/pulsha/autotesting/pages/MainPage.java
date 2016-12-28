package com.pulsha.autotesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://tut.by/";
		
	@FindBy(linkText = "Финансы")
	private WebElement buttonFinance;

	@FindBy(linkText = "ТВ-гид")
	private WebElement buttonTV;

	@FindBy(css = "a.topbar-burger")
	private WebElement buttonResourses;

	@FindBy(linkText = "Все разделы")
	private WebElement buttonAllResourses;

	@FindBy(css = "a.sub-inf span")
	private WebElement spanCurrency;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOnButtonFinance()
	{
		buttonFinance.click();
	}

	public void clickOnButtonTVPage() { buttonTV.click(); }

	public void clickOnButtonResourses() { buttonResourses.click(); }

	public void clickOnButtonAllResourses() { buttonAllResourses.click(); }

	public String getDollarCurrency()
	{
		return spanCurrency.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
}
