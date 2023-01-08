package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    //локаторы
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By inputSubway = By.xpath(".//input[@placeholder='* Станция метро']");
    private By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    private By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By inputCountDays = By.className("Dropdown-placeholder");
    private By inputListCountDays = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    private By inputColorScooter = By.id("black");
    private By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    private By headerWindow = By.className("Order_ModalHeader__3FDaJ");

       //методы
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setSubway() {
        driver.findElement(inputSubway).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void setOrderFormPart1(String name, String surname,String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setSubway();
        setPhone(phone);
    }

}
