import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class checkboxverify {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void verifyBoxes() {

        List<WebElement> checkboxes =
                driver.findElements(By.cssSelector("input[type='checkbox']"));

        int totalCheckboxes = checkboxes.size();
        System.out.println("total checkboxes : " + totalCheckboxes);

        int checkedCount = 0;
        int uncheckedCount = 0;

        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkedCount += 1;
            } else {
                uncheckedCount += 1;
            }
        }

        System.out.println("total checked : " + checkedCount);
        System.out.println("total unchecked : " + uncheckedCount);

        Assert.assertEquals(
                totalCheckboxes,
                checkedCount + uncheckedCount,
                "checkbox count incorrect"
        );

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(
                    checkbox.isSelected(),
                    "checkbox wasnt selected"
            );
        }

        System.out.println("after dinamic selec");

        for (int i = 0; i < checkboxes.size(); i++) {
            System.out.println(
                    "Checkbox " + (i + 1) + " Selected " + checkboxes.get(i).isSelected()

            );
        }

    }
    @AfterMethod
    public void tearDown() {
            if (driver!=null) {
                driver.quit();
            }
        }

    }

