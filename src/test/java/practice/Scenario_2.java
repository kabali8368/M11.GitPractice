package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Scenario_2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("kabalikabali");
		driver.findElement(By.name("company")).sendKeys("faureciafaurecia");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String LeadHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(LeadHeader);
		
		if (LeadHeader.contains("kabalikabali"))
				{
			System.out.println("Pass");
				}
		else 
		{
			System.out.println("Fail");
		}
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out"));
		System.out.println("Logout successfull");
		
		driver.quit();
		
		
		
	}

}
