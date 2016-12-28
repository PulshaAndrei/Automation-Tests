package com.pulsha.autotesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TVPage extends AbstractPage
{
    private final String BASE_URL = "https://tvset.tut.by/";

    @FindBy(css = "h2.b-h2-date")
    private WebElement date;

    public TVPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public int getDay() {
        String str = date.getText().replaceAll("\\D+","");
        return Integer.parseInt(str);
    }
}