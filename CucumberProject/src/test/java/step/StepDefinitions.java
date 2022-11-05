package step;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Given("I launch chromebrowser")
	public void i_launch_chromebrowser() {
		
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver","d:\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}

	@Given("I launch hrm webpage")
	public void i_launch_hrm_webpage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("enter username and password")
	public void enter_username_and_password() {
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

	}

	@When("press login button")
	public void press_login_button() {
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("User must successfully login")
	public void user_must_successfully_login() {
	   
		String title= driver.getTitle();
	   System.out.println("Title of login page: "+title);
	   if (title.equals("OrangeHRM"))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	}

	@Then("close browser")
	public void close_browser() {
	 driver.close();
	}
	
}
