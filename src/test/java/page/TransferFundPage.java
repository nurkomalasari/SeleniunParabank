package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TransferFundPage extends BasePage {
    public TransferFundPage(WebDriver driver){
        super(driver);
    }
    By linkMenuTransfer = By.cssSelector("a[href='transfer.htm']");
    By amount = By.id("amount");
    By btnTransfer = By.cssSelector("input[value='Transfer']");
    By textTransferSuccess = By.xpath("//h1[text()='Transfer Complete!']");


    public TransferFundPage clickMenuTransfer(){
        clickHelper.waitUntilClickableAndClick(linkMenuTransfer);
        return this;
    }
    public TransferFundPage inputAmount(String amn){
        inputHelper.waitAndInput(amount,amn);
        System.out.println("Inputting amount: " + amn);
        System.out.println("Locator found: " + driver.findElement(amount).getAttribute("outerHTML"));

        return this;
    }

    public TransferFundPage setBtnTransfer(){
        clickHelper.waitUntilVisibleAndClick(btnTransfer);
        return this;
    }
    public TransferFundPage verifyTransferSuccessfully(){
        String actualText = textHelper.waitAndGetText(textTransferSuccess);
        Assert.assertEquals(actualText, "Transfer Complete!", "Transfer tidak berhasil!");
        return this;
    }


}
