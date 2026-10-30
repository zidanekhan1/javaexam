import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class dropdowntest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void verifyDropdown() {
        WebElement dropdownElement =
                driver.findElement(By.id("dropdown"));

        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();

        System.out.println("total options : " + options.size());

        Assert.assertEquals(options.size(), 3,
                "Incorrect number of dropdown items");

        String defaultValue =
                dropdown.getFirstSelectedOption().getText();

        System.out.println("default selected value : " + defaultValue);

        Assert.assertEquals(defaultValue, "Please select an option",
                "Incorrect default value");

        dropdown.selectByVisibleText("Option 1");

        String selectedValue =
                dropdown.getFirstSelectedOption().getText();

        System.out.println("selected value : " + selectedValue);

        Assert.assertEquals(selectedValue, "Option 1",
                "option 1 wasnt selected");

        dropdown.selectByIndex(2);

        selectedValue =
                dropdown.getFirstSelectedOption().getText();

        System.out.println("selected by index : "+selectedValue);

        Assert.assertEquals(selectedValue, "Option 2",
                "option 2 wasnt selected");

        dropdown.selectByValue("1");
        selectedValue =
                dropdown.getFirstSelectedOption().getText();

        System.out.println("Selected by value : " + selectedValue);

        Assert.assertEquals(selectedValue, "Option 1",
                "Option 1 was not selected by value");
    }
    @AfterMethod
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }
}
