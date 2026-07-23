package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import static config.Config.getProperty;


public class DriverManager {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  private static ThreadLocal<String> currentTestName = new ThreadLocal<>();

  private DriverManager() {
  }

  public static void setTestName(String testName) {
    currentTestName.set(testName);
    System.setProperty("testName", testName);
  }

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      String browser = getProperty("browser");
      if (Boolean.parseBoolean(getProperty("selenoidEnable"))) {
        initRemoteDriver(browser);
      } else {
        initLocalDriver(browser);
      }
    }
    return driver.get();
  }

  private static void initRemoteDriver(String browser) {
    String testName = currentTestName.get();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
    String timestamp = sdf.format(new Date());
    String videoFileName = browser + "_" + testName + "_" + timestamp + ".mp4";
    System.out.println("🎥 Video file: " + videoFileName);
    try {
      switch (browser.toLowerCase()) {
        case "chrome" -> {
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--no-sandbox");
          chromeOptions.addArguments("--disable-dev-shm-usage");
          if (Boolean.parseBoolean(getProperty("headless"))) {
            chromeOptions.addArguments("--headless=new");
          }
          chromeOptions.setCapability("selenoid:options", Map.of(
                  "enableVNC", true,
                  "enableVideo", true,
                  "videoName", videoFileName,
                  "sessionTimeout", "2m"
          ));

          driver.set(new RemoteWebDriver(
                  new URL(getProperty("selenoidUrl")), chromeOptions));
        }
        case "firefox" -> {
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          if (Boolean.parseBoolean(getProperty("headless"))) {
            firefoxOptions.addArguments("--headless");
          }
          firefoxOptions.setCapability("selenoid:options", Map.of(
                  "enableVNC", true,
                  "enableVideo", true,
                  "videoName", videoFileName,
                  "sessionTimeout", "2m"
          ));

          driver.set(new RemoteWebDriver(
                  new URL(getProperty("selenoidUrl")), firefoxOptions));
        }
        default -> throw new IllegalArgumentException("Unsupported remote browser: " + browser);
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Invalid Selenoid URL", e);
    }
  }
  private static void initLocalDriver(String browser) {
    switch (browser.toLowerCase()) {
      case "chrome" -> {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver.set(new ChromeDriver(options));
      }
      case "firefox" -> {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");

        driver.set(new FirefoxDriver(options));
      }
      default -> throw new IllegalArgumentException("Передан неподдерживаемый браузер");
    }
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
