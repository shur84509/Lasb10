package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void injectStudentInfo() {
        String script = """
            var div = document.createElement('div');
            div.style.position = 'fixed';
            div.style.top = '15px';
            div.style.right = '15px';
            div.style.padding = '12px 18px';
            div.style.background = 'rgba(0, 0, 0, 0.9)';
            div.style.color = '#00ff00';
            div.style.fontSize = '15px';
            div.style.fontWeight = 'bold';
            div.style.zIndex = '99999';
            div.style.borderRadius = '6px';
            div.style.border = '2px solid #00ff00';
            div.style.boxShadow = '0 0 10px rgba(0, 255, 0, 0.5)';
            div.innerHTML = 'Петренко Артем<br>БІП3-23 | ЛР №8 | Варіант 12<br>Хмарне сховище файлів';
            document.body.appendChild(div);
        """;
        ((JavascriptExecutor) driver).executeScript(script);
    }
}