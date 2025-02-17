package seleniumwebcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		WebElement element = driver.findElement(By.xpath("//a[text()='22']"));
		element.click();
		String selecteddate = element.getText();
		System.out.println(selecteddate);
		Thread.sleep(1000);

		driver.quit();
		System.out.println("Browser closed");

	}

}
/*outpu
 * 22
Browser closed
*/
