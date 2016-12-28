package com.pulsha.autotesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage extends AbstractPage
{
    private final String BASE_URL = "https://tam.by/strojka/okna/";

    @FindBy(css = "#allCitySelect")
    private WebElement title;

    public WindowsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}