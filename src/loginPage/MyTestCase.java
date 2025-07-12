package loginPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase {

	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	@BeforeTest
	public void mysetup() {
		driver.get(theURL);
		driver.manage().window().maximize();

	}

	@Test
	public void Singup() throws InterruptedException {

		driver.navigate().to(SignupPage);
// Element
		WebElement FirstNameInbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
		WebElement lastnameInbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_lastname\"]"));
		WebElement EmailInbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_email\"]"));
		WebElement toloInbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_telephone\"]"));
		WebElement faxInbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_company\"]"));
		WebElement address1Inbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_address_1\"]"));
		WebElement adderess2Inbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_address_2\"]"));
		WebElement CityInbut = driver.findElement(By.xpath("//*[@id=\"AccountFrm_city\"]"));
        WebElement zipcodInbut = driver.findElement(By.id("AccountFrm_postcode"));
        WebElement loginInbut = driver.findElement(By.id("AccountFrm_loginname"));
        WebElement passworInput =driver.findElement(By.id("AccountFrm_password"));
        WebElement passwordconfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
        WebElement agreeBox = driver.findElement(By.id("AccountFrm_agree"));
        WebElement continuebotton = driver.findElement(By.cssSelector("button[title='Continue']"));
        WebElement countryselect=driver.findElement(By.id("AccountFrm_country_id"));
        WebElement regionselect=driver.findElement(By.id("AccountFrm_zone_id"));

        
// data
		String [] FirstNames = {"omar","mohammad","raghad","Remas","Hamza"};
		int randomIndaxforfirstname = rand.nextInt(FirstNames.length);
		String randomfirstname =FirstNames[randomIndaxforfirstname];
		
		
		String [] lastnames = {"aii","pmar","rmarcoko"};
		int randomIndaxforlastnames = rand.nextInt(lastnames.length);
		String randomlastname = lastnames[randomIndaxforlastnames];
		
		
		int randomIndaxforemail = rand.nextInt(7000);
		String email = randomfirstname+randomlastname+randomIndaxforemail+"@gmail.com";	
		String fax="3909";
		String telephone = "0790978";
		String company = "qattous";	
		String address_1 = "ammank";
		String address_2 = "sport city";
		String city = "Amman";
		String zipcode= "9090";
		String login= randomfirstname+randomlastname+randomIndaxforemail;
		String password = "Test@1234";
		String passwordconfirm = "Test@1234";
		
//action 
		FirstNameInbut.sendKeys(randomfirstname);
		lastnameInbut.sendKeys(randomlastname);
		EmailInbut.sendKeys(email);
		toloInbut.sendKeys(telephone);
		faxInbut.sendKeys(fax);
		faxInbut.sendKeys(company);
		address1Inbut.sendKeys(address_1);
		adderess2Inbut.sendKeys(address_2);
		CityInbut.sendKeys(city);
		
		
		Select myselectforthecountry =new Select(countryselect);
		
		myselectforthecountry.selectByContainsVisibleText("Jordan");
		
		Thread.sleep(1000);
		
		
	    int numberOfOptions=regionselect.findElements(By.tagName("option")).size();
	    
	    System.out.println();
		
		Select myselectfortheregion =new Select(regionselect);
		int randomregionIndex=rand.nextInt(1,numberOfOptions);
		myselectfortheregion.selectByIndex(randomregionIndex);

		
		zipcodInbut.sendKeys(zipcode);
		loginInbut.sendKeys(login);
		passworInput.sendKeys(password);
		passwordconfirmInput.sendKeys(passwordconfirm);
		agreeBox.click();
		continuebotton.click();
		
		
		
		

	}

}
