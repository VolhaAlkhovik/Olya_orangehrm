package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Mytest {
  private static WebDriver driver;
  private static WebDriverWait wait;

  public static void main(String[] args) {
    driver = WebDriverManager.chromedriver().create();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    testLogin();
    addEmployee();
  }

    public static void testLogin() {
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      driver.manage().window().maximize();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

      driver.findElement(By.name("username")).sendKeys("Admin");
      driver.findElement(By.name("password")).sendKeys("admin123");

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));

      driver.findElement(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'oxd-userdropdown-tab']")));

      driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-filter']")));

    }
    public static void addEmployee() {

      driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type = 'submit']")));

      driver.findElement(By.xpath("//input[contains(@class, 'active orangehrm-firstname')]")).sendKeys("FirstTestName");
      driver.findElement(By.xpath("//input[contains(@class, 'active orangehrm-middlename')]")).sendKeys("MiddleTestName");
      driver.findElement(By.xpath("//input[contains(@class, 'active orangehrm-lastname')]")).sendKeys("LastTestName");
      //driver.findElement(By.xpath("//input[@fdprocessedid='eh7s2g']")).sendKeys();
      driver.findElement(By.xpath("//button[@type = 'submit']")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
    }
  }
