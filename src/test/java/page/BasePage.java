package page;

import helpers.*;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitClickHelper clickHelper;
    protected WaitInputHelper inputHelper;
    protected ScrollHelper scrollHelper;
    protected GetTextHelper textHelper;
    protected SelectHelper selectHelper;

    // Timeout default bisa diatur di sini
    private static final int DEFAULT_TIMEOUT = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Inisialisasi helper dengan driver dan timeout
        this.clickHelper = new WaitClickHelper(driver, DEFAULT_TIMEOUT);
        this.inputHelper = new WaitInputHelper(driver, DEFAULT_TIMEOUT);
        this.scrollHelper = new ScrollHelper(driver, DEFAULT_TIMEOUT);
        this.textHelper = new GetTextHelper(driver, DEFAULT_TIMEOUT);
        this.selectHelper = new SelectHelper(driver, DEFAULT_TIMEOUT);
    }

}
