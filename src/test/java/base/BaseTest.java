package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    WebDriver driver;
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    @BeforeMethod
    public void setUp(){

        initDriver();
        CommonSteps commonSteps = new CommonSteps(driver);
        commonSteps.loginToDashboard();
    }

    public WebDriver initDriver(){
        switch (System.getProperty("browser", "chrome").toLowerCase()){
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--private");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
        }
        driverThreadLocal.set(driver); // Store the driver in ThreadLocal for thread safety

        return null;
    }

    public WebDriver getDriver(){
        return  driverThreadLocal.get();
    }

    @AfterMethod
    public void tearDown(){
        WebDriver driver = driverThreadLocal.get();
//        if (driver !=null){
//            driver.quit();
//        }
    }
}
