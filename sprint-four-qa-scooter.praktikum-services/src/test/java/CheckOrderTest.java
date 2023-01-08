import browserSettings.ConfigBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.ClientPageScooter;
import pageObjects.MainPageScooter;
import pageObjects.RentPageScooter;

@RunWith(Parameterized.class)
public class CheckOrderTest extends ConfigBrowser {
    //private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String metro;
    private final String date;
    private final int durationOption;
    private final String colorOption;
    private final String comment;

    public CheckOrderTest(String name, String lastName, String address, String phone, String metro, String date, int durationOption, String colorOption, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.date = date;
        this.durationOption = durationOption;
        this.colorOption = colorOption;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDescriptions() {
        return new Object[][] {
                {"Андрей", "Иванов", "Улица Московская, д. 12, кв. 1", "+79112234544", "Арбатская", "01.02.2023", 1, "black", "Просто"},
               // {"Иван", "Петров", "пр.-т Строителей, д. 2, кв. 12", "+79053534455", "Пушкинская", "02.01.2021", 2, "grey", "ждём"}
        };
    }

    // Проверка заказа через верхнюю кнопку "Заказать" в Chrome
    @Test
    public void upperOrderTestChrome() {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/scr/main/resources/chromedriver");
        WebDriverManager.chromedriver().driverVersion("108.0.5359.125").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Принимаем куки, чтобы панель не мешала
        objMainPage.cookieButtonClick();

        // Нажатие на верхнюю кнопку "Заказать"
        objMainPage.upperOrderClick();

        // Создание объекта класса заполнение деталей клиента
        ClientPageScooter objClientPage = new ClientPageScooter(driver);

        // Ожидание загрузки страницы
        objClientPage.waitForLoadPage();

        // Заполняем поля данных клиента
        objClientPage.inputClientData(name, lastName, address, phone);

        // Заполняем поле "Станция метро"
        objClientPage.inputMetroData(metro);

        // Нажимаем кнопку "Далее"
        objClientPage.forwardClick();

        // Создание объекта класса заполнение деталей заказа
        RentPageScooter objRentPage = new RentPageScooter(driver);

        // Ожидание загрузки страницы
        objRentPage.waitForLoadPage();

        // Заполняем поля даты и длительности
        objRentPage.inputOrderData(date, comment);

        // Заполняем поле "Длительность"
        objRentPage.chooseDuration(durationOption);

        // Заполняем поле "Цвет самоката"
        objRentPage.chooseColor(colorOption);

        // Нажимаем кнопку "Заказать"
        objRentPage.orderClick();

        // Ожидание загрузки окна подтверждения заказа
        objRentPage.waitForConfirm();

        // Нажимаем кнопку "Да"
        objRentPage.yesClick();

        // Ожидаем загрузки окна завершения заказа
        objRentPage.waitForFinish();
    }

    // Проверка заказа через нижнюю кнопку "Заказать" в Chrome
    @Test
    public void lowerOrderTestChrome() {
//        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverManager.chromedriver().driverVersion("108.0.5359.125").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Принимаем куки, чтобы панель не мешала
        objMainPage.cookieButtonClick();

        // Скроллим до нижней кнопки "Заказать"
        objMainPage.scrollToLowerOrder();

        // Нажатие на нижнюю кнопку "Заказать"
        objMainPage.lowerOrderClick();

        // Создание объекта класса заполнение деталей клиента
        ClientPageScooter objClientPage = new ClientPageScooter(driver);

        // Ожидание загрузки страницы
        objClientPage.waitForLoadPage();

        // Заполняем поля данных клиента
        objClientPage.inputClientData(name, lastName, address, phone);

        // Заполняем поле "Станция метро"
        objClientPage.inputMetroData(metro);

        // Нажимаем кнопку "Далее"
        objClientPage.forwardClick();

        // Создание объекта класса заполнение деталей заказа
        RentPageScooter objRentPage = new RentPageScooter(driver);

        // Ожидание загрузки страницы
        objRentPage.waitForLoadPage();

        // Заполняем поля даты и длительности
        objRentPage.inputOrderData(date, comment);

        // Заполняем поле "Длительность"
        objRentPage.chooseDuration(durationOption);

        // Заполняем поле "Цвет самоката"
        objRentPage.chooseColor(colorOption);

        // Нажимаем кнопку "Заказать"
        objRentPage.orderClick();

        // Ожидание загрузки окна подтверждения заказа
        objRentPage.waitForConfirm();

        // Нажимаем кнопку "Да"
        objRentPage.yesClick();

        // Ожидаем загрузки окна завершения заказа
        objRentPage.waitForFinish();
    }

    // Проверка заказа через верхнюю кнопку "Заказать" в Firefox
//    @Test
//    public void upperOrderTestFirefox() {
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://qa-scooter.praktikum-services.ru/");
//
//        // Создание объекта класса главной страницы
//        MainPageScooter objMainPage = new MainPageScooter(driver);
//
//        // Принимаем куки, чтобы панель не мешала
//        objMainPage.cookieButtonClick();
//
//        // Нажатие на верхнюю кнопку "Заказать"
//        objMainPage.upperOrderClick();
//
//        // Создание объекта класса заполнение деталей клиента
//        ClientPageScooter objClientPage = new ClientPageScooter(driver);
//
//        // Ожидание загрузки страницы
//        objClientPage.waitForLoadPage();
//
//        // Заполняем поля данных клиента
//        objClientPage.inputClientData(name, lastName, address, phone);
//
//        // Заполняем поле "Станция метро"
//        objClientPage.inputMetroData(metro);
//
//        // Нажимаем кнопку "Далее"
//        objClientPage.forwardClick();
//
//        // Создание объекта класса заполнение деталей заказа
//        RentPageScooter objRentPage = new RentPageScooter(driver);
//
//        // Ожидание загрузки страницы
//        objRentPage.waitForLoadPage();
//
//        // Заполняем поля даты и длительности
//        objRentPage.inputOrderData(date, comment);
//
//        // Заполняем поле "Длительность"
//        objRentPage.chooseDuration(durationOption);
//
//        // Заполняем поле "Цвет самоката"
//        objRentPage.chooseColor(colorOption);
//
//        // Нажимаем кнопку "Заказать"
//        objRentPage.orderClick();
//
//        // Ожидание загрузки окна подтверждения заказа
//        objRentPage.waitForConfirm();
//
//        // Нажимаем кнопку "Да"
//        objRentPage.yesClick();
//
//        // Ожидаем загрузки окна завершения заказа
//        objRentPage.waitForFinish();
//    }
//
//    // Проверка заказа через нижнюю кнопку "Заказать" в Firefox
//    @Test
//    public void lowerOrderTestFirefox() {
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://qa-scooter.praktikum-services.ru/");
//
//        // Создание объекта класса главной страницы
//        MainPageScooter objMainPage = new MainPageScooter(driver);
//
//        // Принимаем куки, чтобы панель не мешала
//        objMainPage.cookieButtonClick();
//
//        // Скроллим до нижней кнопки "Заказать"
//        objMainPage.scrollToLowerOrder();
//
//        // Нажатие на нижнюю кнопку "Заказать"
//        objMainPage.lowerOrderClick();
//
//        // Создание объекта класса заполнение деталей клиента
//        ClientPageScooter objClientPage = new ClientPageScooter(driver);
//
//        // Ожидание загрузки страницы
//        objClientPage.waitForLoadPage();
//
//        // Заполняем поля данных клиента
//        objClientPage.inputClientData(name, lastName, address, phone);
//
//        // Заполняем поле "Станция метро"
//        objClientPage.inputMetroData(metro);
//
//        // Нажимаем кнопку "Далее"
//        objClientPage.forwardClick();
//
//        // Создание объекта класса заполнение деталей заказа
//        RentPageScooter objRentPage = new RentPageScooter(driver);
//
//        // Ожидание загрузки страницы
//        objRentPage.waitForLoadPage();
//
//        // Заполняем поля даты и длительности
//        objRentPage.inputOrderData(date, comment);
//
//        // Заполняем поле "Длительность"
//        objRentPage.chooseDuration(durationOption);
//
//        // Заполняем поле "Цвет самоката"
//        objRentPage.chooseColor(colorOption);
//
//        // Нажимаем кнопку "Заказать"
//        objRentPage.orderClick();
//
//        // Ожидание загрузки окна подтверждения заказа
//        objRentPage.waitForConfirm();
//
//        // Нажимаем кнопку "Да"
//        objRentPage.yesClick();
//
//        // Ожидаем загрузки окна завершения заказа
//        objRentPage.waitForFinish();
//    }
}
