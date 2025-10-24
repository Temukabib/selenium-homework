import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement inputField = driver.findElement(By.xpath("//form[@id='input-example']/input"));

        System.out.println("Input field enabled and text visible");

        WebElement changedButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        System.out.println("Button text changed successfully");

        inputField.sendKeys("Bootcamp");
        inputField.clear();

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        int yA = columnA.getLocation().getY();
        int yB = columnB.getLocation().getY();
        System.out.println("Columns A and B aligned successfully");

        driver.quit();
    }
}
