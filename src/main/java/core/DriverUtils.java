package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DriverUtils {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public DriverUtils(WebDriver driver, long timeout){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, timeout);
    }



}
