package com.demoautomation1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewLoginWithValidCredentialsTest {
	public WebDriver driver;
	public String url = "";
	public String verificationError = "";

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\WindowsDrive\\Selenium_Jar\\Driver\\Runner\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		url = "http://demo.automationtesting.in/Index.html";
	}

	@Test
	public void cl() {
		driver.get(url);

		driver.findElement(By.id("email")).sendKeys("trainer.saikiran@gmail.com");
		driver.findElement(By.id("enterimg")).click();

		String text = driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']")).getText();
		if (!text.contains("Automation")) {
			verificationError = "false";
		} else {
			System.out.println("Page opened");
		}
	}

	@After
	public void tierDown() {
		driver.quit();
		if (!verificationError.equals("")) {
			Assert.fail(verificationError);
		}
	}
}
