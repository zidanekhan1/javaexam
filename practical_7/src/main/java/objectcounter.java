import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class objectcounter {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("file:///home/zizou/IdeaProjects/practical_7/src/main/java/org/example/objects.html");

        int links = driver.findElements(By.tagName("a")).size();
        int images = driver.findElements(By.tagName("img")).size();
        int buttons = driver.findElements(By.tagName("button")).size();
        int inputs = driver.findElements(By.tagName("input")).size();

        int total = links+images+buttons+inputs;
        System.out.println("numeros del links : " + links);
        System.out.println("numeros del photos : " + images);
        System.out.println("numeros del buttons : " + buttons);
        System.out.println("numeros del inputs : " + inputs);

        System.out.println("total objectos : " + total);

        driver.quit();
    }
}
