package seleniumwebcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automateguvisignup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String pagelink = "https://www.guvi.in/";

		driver.get(pagelink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.className("⭐️rawbli-0")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("xyz");
		driver.findElement(By.id("email")).sendKeys("abcd19@gmail.com");
		driver.findElement(By.xpath("//input[@class='form-control password-err']")).sendKeys("123abc");
		driver.findElement(By.xpath("//input[@class='form-control countrycode-left']")).sendKeys("9876512345");
		driver.findElement(By.id("signup-btn")).click();
		WebElement profile = driver.findElement(By.id("profileDrpDwn"));
		Select dropprofile = new Select(profile);
		dropprofile.selectByValue("Looking for a career");

		WebElement degree = driver.findElement(By.id("degreeDrpDwn"));
		Select dropdegree = new Select(degree);
		dropdegree.selectByIndex(5);

		driver.findElement(By.id("year")).sendKeys("2022");
		driver.findElement(By.id("details-btn")).click();
		Thread.sleep(1000);
		String message = driver.findElement(By.xpath("//h1[contains(.,'Almost Done! Check Your Inbox!')]")).getText();
		System.out.println(message);
		if (message.contains("Almost Done! Check Your Inbox!")) {
			System.out.println("Signed up successfully");
		} else {
			System.out.println("You are not Signed up!");
		}
		driver.navigate().to(pagelink);
		driver.findElement(By.xpath("//a[@id='login-btn']")).click();

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ab19@gmail.com");

		driver.findElement(By.id("password")).sendKeys("123abc");
		WebElement checkbox = driver.findElement(By.id("logged-in"));
		checkbox.click();
		WebElement login = driver.findElement(By.id("login-btn"));
		login.click();
		String text = driver.getTitle();
		System.out.println(text);
		if (text.contains("GUVI | Login")) {
			System.out.println("You're successfully Logged-in");
		} else {
			System.out.println("You're not successfully Logged-in");
		}

	driver.quit();

	}
}