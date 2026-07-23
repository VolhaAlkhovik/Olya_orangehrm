package utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@UtilityClass
public class ScreenshotUtil {


    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {

        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format((new Date()));
        String dirPath = "target/screenshots/";

        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File dest = new File(dirPath + timestamp + ".png");
        try {
            Files.copy(screenshot.toPath(), dest.toPath());
            log.error("Saved screenshot to: {}", dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotBytes;
    }
}
