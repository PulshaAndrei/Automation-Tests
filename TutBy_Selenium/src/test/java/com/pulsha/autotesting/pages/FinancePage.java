package com.pulsha.autotesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FinancePage extends AbstractPage
{
	private final String BASE_URL = "https://finance.tut.by/";
	
	@FindBy(linkText = "НБРБ")
	private WebElement buttonNBRB;

	@FindBy(css = "table.k-table span")
	private WebElement spanCurrency;

	public FinancePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOnButtonNBRB()
	{
		buttonNBRB.click();
	}
	
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