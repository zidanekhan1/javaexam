import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class tablescoreanalysis {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("file:///home/zizou/IdeaProjects/practical_6/src/main/java/org/example/student_marks.html");
            List<WebElement> rows = driver.findElements(
                    By.xpath("//table[@id='studentTable']/tbody/tr")
            );
            int totalStudents = 0;
            int studentsAbove60 = 0;

            for (WebElement row: rows) {
                List<WebElement> columns =
                        row.findElements(By.tagName("td"));

                String studentName = columns.get(0).getText();
                int javaMarks = Integer.parseInt(columns.get(1).getText());
                int dbmsMarks = Integer.parseInt(columns.get(2).getText());

                totalStudents += 1;

                boolean above60 =
                        javaMarks > 60 || dbmsMarks >60;

                if (above60) {
                    studentsAbove60 += 1;
                }

                System.out.println(
                        "Student: " + studentName +
                                " | Java: " + javaMarks +
                                " | DBMS: " + dbmsMarks +
                                " | Above 60: " + above60
                );

                double percentage = 0;

                if (totalStudents >0) {
                    percentage =
                            ((double) studentsAbove60/totalStudents) * 100;
                }

                System.out.println("==================================");
                System.out.println("Total Students: " + totalStudents);
                System.out.println("Students Above 60: " + studentsAbove60);
                System.out.println("Percentage above 60: " + percentage);
            }
        } finally {
            driver.quit();
        }
    }
}
