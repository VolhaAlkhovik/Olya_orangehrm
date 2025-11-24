package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void testLogin() throws InterruptedException {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
        // driver.findElement(By.name("username"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        //  driver.findElement(By.name("password"));
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']"));
        driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[contains(@href, 'viewAdminModule')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys("Username");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text oxd-select-text--active')]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div/span[text() = 'Admin']")).click();
        Thread.sleep(10000);

       // driver.findElement(By.xpath("//button[text()=' Search ']")).click();
      // driver.findElement(By.xpath("//button[text()=' Add ']")).click();

      driver.quit();
  }

}
