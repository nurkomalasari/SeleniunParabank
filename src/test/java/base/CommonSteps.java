package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.LoginPage;

public class CommonSteps {
    WebDriver driver;

    public CommonSteps(WebDriver driver){
        this.driver = driver;
    }

    public void loginToDashboard(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLogin();
        loginPage.inputUsername("lala@gmail.com");
        loginPage.inputPassword("lala123");
        loginPage.clickButtonLogin();
    }

}
