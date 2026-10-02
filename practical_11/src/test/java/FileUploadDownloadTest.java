import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class FileUploadDownloadTest {
    @Test
    void testFilePage() {

        FirefoxOptions options = new FirefoxOptions();

        options.addPreference(
                "browser.download.folderList",2
        );

        options.addPreference(
                "browser.download.dir",
                "/home/zizou/IdeaProjects/practical_11/downloads"
        );

        options.addPreference(
                "browser.helperApps.neverAsk.saveToDisk",
                "text/plain"
        );

        WebDriver driver = new FirefoxDriver(options);

        driver.get("file:///home/zizou/IdeaProjects/practical_11/file_upload_download.html");

        WebElement fileInput = driver.findElement(By.id("fileUpload"));

        fileInput.sendKeys(
                "/home/zizou/IdeaProjects/practical_11/upload_test.txt"
        );

        System.out.println("file selected succesfully");

        WebElement uploadButton = driver.findElement(By.id("uploadButton"));
        uploadButton.click();

        WebElement status = driver.findElement(By.id("uploadStatus"));

        System.out.println("Status: " + status.getText());

        WebElement downloadButton =
                driver.findElement(By.id("downloadButton"));

        System.out.println("download button clicked");

        downloadButton.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File downloadedFile =
                new File(
                        "/home/zizou/IdeaProjects/practical_11/downloads/sample.txt"
                );

        if (downloadedFile.exists()){
            System.out.println("file downloaded successfully");
        } else {
            System.out.println("failed to download file");
        }
        System.out.println("page open");
        driver.quit();
    }
}
