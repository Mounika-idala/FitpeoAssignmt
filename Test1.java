package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import junit.framework.Assert;

public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ScreenRecorderUtil.startRecord("main");
		System.out.println("--------------+++==============-Fitpeo Assignment=--================------------------------------");
	    
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigating to Home Page
        driver.get("https://www.fitpeo.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Navigating to Revenue Calculator page
        driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
        Thread.sleep(3);
        //SCroll down until the slider is visible
        js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(By.xpath("//p[text()='CPT-99454']")));
       WebElement Slider =driver.findElement(By.cssSelector("input[type=\"range\"]"));
        for( ; ; ) 
		{
			if(Slider.getAttribute("value").contains("820")) 
					break;
			else
				Slider.sendKeys(Keys.ARROW_RIGHT);
		}
        Thread.sleep(3000);
        js.executeScript("arguments[0].value='560'", driver.findElement(By.cssSelector("input[type=\"number\"]")));
		if(Slider.getAttribute("value").contains("560")) 
			System.out.println(" Slider updated to 560");
		else
			System.out.println(" Slider is not updated to 560");
	
		driver.findElement(By.xpath("//p[text()='CPT-99091']/following-sibling::label/span/input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99453']/following-sibling::label/span/input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99454']/following-sibling::label/span/input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='CPT-99474']/following-sibling::label/span/input[@type='checkbox']")).click();
		WebElement header=driver.findElement(By.xpath("(//p[contains(text(),'Recurring')])[1]/.//p[contains(text(),'$')]"));
		System.out.println(header.isDisplayed());
		System.out.println(header.getText());
		Assert.assertEquals("Test Passed",header.getText(), "$110700" );
		
		System.out.println("Header displaying Total Recurring Reimbursement for all Patients Per Month : $110700");
		
		Thread.sleep(5000);      
		driver.quit();
		ScreenRecorderUtil.stopRecord();
	}     

}
