package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    WebDriverWait wait;
    public LoginPage (WebDriver driver){
        super(driver);
    }
    By username = By.cssSelector("input[name='username']");
    By password = By.cssSelector("input[name='password']");
    By btnLogin = By.cssSelector("input[type='submit']");

    public void navigateToLogin() {
        String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
        this.driver.get(URL);
        this.driver.manage().window().maximize();

    }
    public void inputUsername(String userName){
        inputHelper.waitAndInput(username,userName);
    }
    public void inputPassword(String pw){
        inputHelper.waitAndInput(password,pw);
    }
    public void clickButtonLogin(){
        clickHelper.waitUntilVisibleAndClick(btnLogin);
    }

}
