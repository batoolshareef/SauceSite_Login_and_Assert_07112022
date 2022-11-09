import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SauceSite_Login_and_Assert_Class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String user_name="standard_user";
		String password = "secret_sauce";
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user_name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(3000);
		
		String actual_app_title = driver.getTitle();
//		System.out.println(actual_app_title);
		
		String expected_app_title = "Swag Labs"; 
//		System.out.println(expected_app_title);
		
//		if(actual_app_title==expected_app_title) {
//			System.out.println("Test PAssed");
//		}
//		else {
//			System.out.println("Test Failed");		
//		}
	
	//---to assirt the actual app title with expected app title
		Assert.assertEquals(actual_app_title, expected_app_title);
	
	int actual_added_item=6;
	
	
	
		List <WebElement> add_card_btn = driver.findElements(By.className("btn_primary"));
		
		for (int i=0; i<add_card_btn.size();i++) {
			driver.findElement(By.className("btn_primary")).click();
			Thread.sleep(1000);
		}
	Thread.sleep(3000);
	
	WebElement shopping_cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
	
	String shopping_cart_str = shopping_cart.getText();
//	System.out.println("the expected val string is: "+ shopping_cart_str );
	
	int expected_shopping_cart_int = Integer.parseInt(shopping_cart_str);
//	System.out.println("the expected val integer is: "+ expected_shopping_cart_int );
	
	Assert.assertEquals(actual_added_item, expected_shopping_cart_int);
	
	}

}
