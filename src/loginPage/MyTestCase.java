package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase {
	
	
	WebDriver driver= new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create"; 

	
	
	
	@BeforeTest 
	public void mysetup() {
		driver.get(theURL);
		driver.manage().window().maximize(); 
		
		
	}
	
	
	
	@Test
	public void Singup() {
		
		driver.navigate().to(SignupPage);
		WebElement FirstName = driver.findElement(By.name("firstname"));
		FirstName.sendKeys("omar");
		//hihi
	}

}
