package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegressionOnlineLearningTest {

    private WebDriver driver;
    private UploadPage uploadPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        uploadPage = new UploadPage(driver);
        options.addArguments("--headless"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @Test(description = "Регресійне тестування сторінки завантаження файлів у хмарному сховищі")
    public void testUploadPageAccessibility() {
        uploadPage.openPage("https://demoqa.com/");
        uploadPage.injectStudentInfo();

        uploadPage.goToUploadSection();

        Assert.assertTrue(uploadPage.isUploadButtonVisible(),
                "Кнопка завантаження файлу не відображається!");

        System.out.println("✅ Регресійний тест сторінки хмарного сховища пройдено успішно!");
        System.out.println("Браузер залишено відкритим для перевірки.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Тест завершено. Браузер залишено відкритим.");
        // driver.quit();  // Закоментовано
    }
}
