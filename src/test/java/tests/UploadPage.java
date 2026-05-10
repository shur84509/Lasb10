package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePage {

    private final By uploadSection = By.xpath("//span[text()='Upload and Download']");
    private final By chooseFileButton = By.id("uploadFile");

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public void goToUploadSection() {
        driver.findElement(uploadSection).click();
    }

    public boolean isUploadButtonVisible() {
        return driver.findElement(chooseFileButton).isDisplayed();
    }
}