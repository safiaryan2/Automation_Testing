package steps;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiSteps extends Steps {

	private static WebDriver driver = null;

	@Given("I open a browser")
	public void openingABrowser() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
	}

	@When("I enter $url and hit the enter key")
	public void enteringUrl(String url) {
		driver.get(url);
	}

	@Then("$title is displayed")
	public void titleSerach(String title) throws InterruptedException {
		org.junit.Assert.assertEquals(title, driver.getTitle());
		
	}

	@Given("$url is open")
	public void googleOpen() {

	}

	@When("I enter honda it will show search result")
	public void enteringText() {
		driver.findElement(By.name("q")).sendKeys("honda");
	}

	@Then("Honda will be selected")
	public void searchresult() {
		////ul[@role='listbox']/li/descendant::div[@class='sbl1']"]
		List<WebElement> list = driver.findElements(By.xpath("ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) 
		{
			String searchOptions = list.get(i).getText();
			System.out.println(searchOptions);
			if (searchOptions.contains("honda canada")) 
			{
				list.get(i).click();
				break;
			}

		}
	}
}
