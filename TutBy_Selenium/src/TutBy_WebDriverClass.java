import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TutBy_WebDriverClass {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://tut.by");
		
		String dollarHomepage = driver.findElement(By.cssSelector("a.sub-inf span")).getText();		
		
		driver.findElement(By.linkText("Финансы")).click();
		driver.findElement(By.linkText("НБРБ")).click();
		
		String dollarNbrb = driver.findElement(By.cssSelector("table.k-table span")).getText();
		
		System.out.println(dollarHomepage);
		System.out.println(dollarNbrb);
		System.out.println(dollarHomepage.substring(1).equalsIgnoreCase(dollarNbrb));
		
		driver.close();
	}
}
