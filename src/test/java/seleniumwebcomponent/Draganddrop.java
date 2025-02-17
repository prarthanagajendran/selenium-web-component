package seleniumwebcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iframe);

		WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement element2 = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(element1, element2).build().perform();
		String str = element2.getText();
		System.out.println(str);
		String colour = element2.getCssValue("background-color");
		System.out.println(colour);
		if ("Dropped!".equals(str)) {
			System.out.println("Drag and drop operation was successful!");
		} else {
			System.out.println("Drag and drop operation failed.");
		}
		driver.quit();

	}

}
