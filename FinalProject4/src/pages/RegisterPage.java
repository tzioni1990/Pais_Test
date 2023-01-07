package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean getRegister(String fName, String lName, String dBirth, String gender, String ID, String pPrefix, String pNumber, String aPPrefix, String aPNumber, String eMail) {
		fillText(By.id("fName"), fName);
		fillText(By.id("lName"), lName);
		fillText(By.id("dateOfBirth"), dBirth);
		getRadioButton(By.id("radio_sex"), gender);
		fillText(By.id("idNum"), ID);
		getRadioButton(By.id("phonePrefixMain"), pPrefix);
		fillText(By.id("mainPhone"), pNumber);
		getRadioButton(By.id("phonePrefixSecondary"), aPPrefix);
		fillText(By.id("secondaryPhone"), aPNumber);
		fillText(By.id("subscriberEmail"), eMail);
		return true;
	}
	
	public boolean getPageBack() {
		String sMainWinGUID=driver.getWindowHandle();
		System.out.println(sMainWinGUID);
		Set<String> sWinHandle=driver.getWindowHandles();
		for(String str:sWinHandle)
			if(!str.equals(sMainWinGUID))
				driver.switchTo().window(str);
		return true;
	}

}
