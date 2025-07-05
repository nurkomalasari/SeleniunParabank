package testcases;

import base.BaseTest;
import org.testng.annotations.Test;
import page.TransferFundPage;

public class TransferFundTest extends BaseTest {

    @Test
    public void transferFundSuccessfully(){
        TransferFundPage transferFundPage = new TransferFundPage(getDriver());
        transferFundPage
                .clickMenuTransfer()
                .inputAmount("100000")
                .setBtnTransfer()
                .verifyTransferSuccessfully();

    }
}
