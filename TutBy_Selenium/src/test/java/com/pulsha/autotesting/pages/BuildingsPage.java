package com.pulsha.autotesting.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BuildingsPage extends AbstractPage
{
    private final String BASE_URL = "https://tam.by/strojka/";

    @FindBy(css = "h1.title_catalog_page")
    private WebElement title;

    @FindBy(linkText = "Окна")
    private WebElement windowsButton;

    public BuildingsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickOnButtonWindows() {
        windowsButton.click();
    }
}