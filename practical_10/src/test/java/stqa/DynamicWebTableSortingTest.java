package stqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicWebTableSortingTest {

    @Test
    void testTable() {

        WebDriver driver = new FirefoxDriver();

        driver.get("file:///home/zizou/IdeaProjects/practical_10/student_table.html");

        List<WebElement> rows =
                driver.findElements(By.cssSelector("#studentTable tbody tr"));

        System.out.println("Total students: " + rows.size());

        for (WebElement row : rows) {
            String name = row.findElements(By.tagName("td")).get(0).getText();
            String javaMarks = row.findElements(By.tagName("td")).get(1).getText();
            String dbmsMarks = row.findElements(By.tagName("td")).get(2).getText();

            System.out.println(
                    name + " | Java: " + javaMarks + " | DBMS " + dbmsMarks
            );
        };
        WebElement javaHeader =
                driver.findElement(By.cssSelector("#studentTable th:nth-child(2)"));

        javaHeader.click();
        List<Integer> actualMarks = new ArrayList<>();

        List<WebElement> sortedRows =
                driver.findElements(By.cssSelector("#studentTable tbody tr"));

        for (WebElement row : sortedRows) {

            String marksText =
                    row.findElements(By.tagName("td")).get(1).getText();

            actualMarks.add(Integer.parseInt(marksText));
        }

        System.out.println("Sorted Java marks: " + actualMarks);
        System.out.println("Page opened");

        driver.quit();
    }
}
