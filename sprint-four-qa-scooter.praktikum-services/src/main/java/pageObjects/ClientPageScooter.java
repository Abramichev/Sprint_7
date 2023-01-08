package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPageScooter {
    private WebDriver driver;
    private By name = By.xpath(".//input[@placeholder = '* Имя']");
    private By lastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By address = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By phoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By metroStation = By.className("select-search__input");
    private By firstMetroOption = By.xpath(".//li[1]");
    private By forwardButton = By.xpath(".//button[text()='Далее']");

    public ClientPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadPage() {
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
    }

    public void inputClientData(String inputName, String inputLastName, String inputAddress, String inputPhoneNumber) {
        this.driver.findElement(this.name).sendKeys(new CharSequence[]{inputName});
        this.driver.findElement(this.lastName).sendKeys(new CharSequence[]{inputLastName});
        this.driver.findElement(this.address).sendKeys(new CharSequence[]{inputAddress});
        this.driver.findElement(this.phoneNumber).sendKeys(new CharSequence[]{inputPhoneNumber});
    }

    public void inputMetroData(String inputMetroStation) {
        this.driver.findElement(this.metroStation).sendKeys(new CharSequence[]{inputMetroStation});
        this.driver.findElement(this.firstMetroOption).click();
    }

    public void forwardClick() {
        this.driver.findElement(this.forwardButton).click();
    }
}
