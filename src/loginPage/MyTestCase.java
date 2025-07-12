package loginPage;

import java.util.List;
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
     
	String theUserName;
	String thePassword="Test@1234";

	@BeforeTest
	public void mysetup() {
		driver.get(theURL);
		driver.manage().window().maximize();

	}

	@Test(priority=1,enabled = false)
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
		WebElement passworInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordconfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement agreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement continuebotton = driver.findElement(By.cssSelector("button[title='Continue']"));
		WebElement countryselect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement regionselect = driver.findElement(By.id("AccountFrm_zone_id"));

// data
		
		String[] FirstNames = { "omar", "mohammad", "raghad", "Remas", "Hamza" };
		int randomIndaxforfirstname = rand.nextInt(FirstNames.length);
		String randomfirstname = FirstNames[randomIndaxforfirstname];

		String[] lastnames = { "aii", "pmar", "rmarcoko" };
		int randomIndaxforlastnames = rand.nextInt(lastnames.length);
		String randomlastname = lastnames[randomIndaxforlastnames];
		

		int randomIndaxforemail = rand.nextInt(7000);
		String email = randomfirstname + randomlastname + randomIndaxforemail + "@gmail.com";
		String fax = "3909";
		String telephone = "0790978";
		String company = "qattous";
		String address_1 = "ammank";
		String address_2 = "sport city";
		String city = "Amman";
		String zipcode = "9090";
		String login = randomfirstname + randomlastname + randomIndaxforemail;
		

//action 
		theUserName= randomfirstname + randomlastname + randomIndaxforemail ;
		
		
		FirstNameInbut.sendKeys(randomfirstname);
		lastnameInbut.sendKeys(randomlastname);
		EmailInbut.sendKeys(email);
		toloInbut.sendKeys(telephone);
		faxInbut.sendKeys(fax);
		faxInbut.sendKeys(company);
		address1Inbut.sendKeys(address_1);
		adderess2Inbut.sendKeys(address_2);
		CityInbut.sendKeys(city);

		int numberOfOptionss = countryselect.findElements(By.tagName("option")).size();
		System.out.println();
		Select myselectforthecountry = new Select(countryselect);
		int randomcountryIndex = rand.nextInt(1, numberOfOptionss);
		myselectforthecountry.selectByIndex(randomcountryIndex);

		Thread.sleep(1000);

		int numberOfOptions = regionselect.findElements(By.tagName("option")).size();

		System.out.println();

		Select myselectfortheregion = new Select(regionselect);
		int randomregionIndex = rand.nextInt(1, numberOfOptions);
		myselectfortheregion.selectByIndex(randomregionIndex);

		zipcodInbut.sendKeys(zipcode);
		loginInbut.sendKeys(login);
		passworInput.sendKeys(thePassword);
		passwordconfirmInput.sendKeys(thePassword);
		agreeBox.click();
		continuebotton.click();

	}
@Test(priority= 2,enabled = false)
public void Logout () throws InterruptedException {
	 WebElement logoutbutton = driver.findElement(By.linkText("Logoff"));
	 logoutbutton.click();
	 
	 Thread.sleep(1000);
	 
	 WebElement continuobutton=driver.findElement(By.linkText("Continue"));
	 continuobutton.click();
	
	
	
	
	
	
	
}
@Test(priority=3,enabled = false)
public void Login() {
	WebElement loginButton=driver.findElement(By.partialLinkText("Login or"));
	
	loginButton.click();
	WebElement loginbuttonn=driver.findElement(By.id("loginFrm_loginname"));
	WebElement passwordbutton=driver.findElement(By.id("loginFrm_password"));
	loginbuttonn.sendKeys(theUserName);
	passwordbutton.sendKeys(thePassword);
	
	WebElement LoginButton=driver.findElement(By.xpath("//button[@title='Login']"));
	
	LoginButton.click();
	
	

	
}
@Test(priority=4)
public void addToCard() throws InterruptedException {
	driver.navigate().to(theURL);
	Thread.sleep(1000);
	
	List<WebElement>theListOfItem=driver.findElements(By.className("prdocutname"));
	
	int TotalNumberOfItems = theListOfItem.size();
	
	System.out.println(TotalNumberOfItems);
	
	int RandomItemIndex = rand.nextInt(2);
	
	theListOfItem.get(RandomItemIndex).click();
	
	
	Thread.sleep(3000);
	if(driver.getPageSource().contains("out of Stock")) {
		driver.navigate().back();
		System.out.println("sorry the item is out of stock");
	}else {
		System.out.println("the item is avilabel");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


}
