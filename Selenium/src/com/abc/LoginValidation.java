package com.abc;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Selenium\\DataDriven.properties");
		Properties p=new Properties();

		p.load(fis);

		String url=p.getProperty("url");
		String email=p.getProperty("email");
		String password=p.getProperty("password");

		driver.get(url);

		WebElement myAcct=driver.findElement(By.linkText("My Account"));
		myAcct.click();

		WebElement em=driver.findElement(By.id("email"));
		em.sendKeys(email);


		WebElement pwd=driver.findElement(By.id("pass"));
		pwd.sendKeys(password);


		WebElement login=driver.findElement(By.id("send2"));
		login.click();



		WebElement logout=driver.findElement(By.linkText("log out"));
		logout.click();

		driver.quit();

	}

}
