package com.pulsha.autotesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResoursesPage extends AbstractPage
{
    private final String BASE_URL = "https://www.tut.by/resource/";

    @FindBy(css = "div.m_header > h1")
    private WebElement titleCatalog;

    @FindBy(linkText = "Строительство в  Минске")
    private WebElement buttonBuildings;

    public ResoursesPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle() {
        return titleCatalog.getText();
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void openBuildings() {
        buttonBuildings.click();
    }
}
