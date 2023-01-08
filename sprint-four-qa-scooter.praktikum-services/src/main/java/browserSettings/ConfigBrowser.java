package browserSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ConfigBrowser {


    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {//выбор брузера Хром или Мазила
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

}
