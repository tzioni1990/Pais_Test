package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean getHomePage() {
		fillText(By.xpath("//input[@name='q']"), "מפעל הפיס");
		getClick(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
		getClick(By.xpath("//a[@href='https://www.pais.co.il/']/h3"));
		String sMainWinGUID=driver.getWindowHandle();
		System.out.println(sMainWinGUID);
		getClick(By.xpath("//div/ul//a[text()='הצטרפו למנוי פיס']"));
		Set<String> sWinHandle=driver.getWindowHandles();
		for(String str:sWinHandle)
			if(!str.equals(sMainWinGUID))
				driver.switchTo().window(str);
		if(driver.findElement(By.xpath("//h2[text()='פרטים אישיים להצטרפות']")).isDisplayed())
			return true;
		else 
			return false;
	}

}
