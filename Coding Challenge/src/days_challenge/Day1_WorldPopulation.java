package days_challenge;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_WorldPopulation {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		String current_population = "//div[@class='maincounter-number']/span[@class='rts-counter']";
		String today_thisyear_xpath = "//div[text()='Today'or text()='This year']//parent::div//span[@class='rts-counter']";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.worldometers.info/world-population/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		int count = 1;
		while(count<=20) {
			System.out.println(count+ " sec");
			if(count==21)
				break;
		
		System.out.println("-------------Current World Population------------- ");
		printPopulationData(current_population);
		System.out.println("-------------Today and This year Population------------- ");
		printPopulationData(today_thisyear_xpath);
		System.out.println("========================================================");
		Thread.sleep(1000);
		count++;
	}
}
	
	public static void printPopulationData(String locator) throws InterruptedException {
		
			List<WebElement> popList = driver.findElements(By.xpath(locator));	
			
			for(WebElement e: popList) {
				System.out.println(e.getText());
			}
			
		}
	
	

}
