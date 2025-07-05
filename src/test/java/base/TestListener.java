package base;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Screenshot;


public class TestListener implements ITestListener {
    Screenshot screenshot = new Screenshot();
    @Override
    public void onTestStart( ITestResult result){
        Allure.step("Starting test" + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        Allure.step("Test passed" + result.getName());

        try {
            String ssName = result.getMethod().getMethodName();
            screenshot.takeScreenshot(ssName);
            screenshot.attachScreenshotPNG(ssName);

        }catch (Exception e){
            System.out.println("Error Taking screenshot on test success" + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailure(ITestResult result){
        Allure.step("Test failed"+ result.getName());

    }
    @Override
    public void onFinish(ITestContext context){
        Allure.step("Finishing test suite"+ context.getName());

    }
}
