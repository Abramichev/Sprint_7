package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPageScooter {
    private WebDriver driver;
    private By date = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By duration = By.className("Dropdown-placeholder");
    private By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    private By setDuration(int durationOptionNumber) {
        return By.xpath(".//div[@class='Dropdown-option'][" + durationOptionNumber + "]");
    }

    private By setColor(String colorOption) {
        return By.xpath(".//input[@id='" + colorOption + "']");
    }

    public RentPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadPage() {
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
    }

    public void inputOrderData(String inputDate, String inputComment) {
        this.driver.findElement(this.date).sendKeys(new CharSequence[]{inputDate});
        this.driver.findElement(this.date).sendKeys(new CharSequence[]{Keys.RETURN});
        this.driver.findElement(this.comment).sendKeys(new CharSequence[]{inputComment});
    }

    public void chooseDuration(int durationOptionNumber) {
        this.driver.findElement(this.duration).click();
        this.driver.findElement(this.setDuration(durationOptionNumber)).click();
    }

    public void chooseColor(String colorOption) {
        this.driver.findElement(this.setColor(colorOption)).click();
    }

    public void orderClick() {
        this.driver.findElement(this.orderButton).click();
    }

    public void waitForConfirm() {
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(this.yesButton));
    }

    public void yesClick() {
        this.driver.findElement(this.yesButton).click();
    }

    public void waitForFinish() {
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Посмотреть статус']")));
    }
}
