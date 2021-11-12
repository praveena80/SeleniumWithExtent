import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccount() {
        LoginPage loginPO = new LoginPage(driver);
        CreateAccountPage createAccountPO = new CreateAccountPage(driver);

        loginPO.selectStoreLink();

        //after you added click method for links then use the below line
        createAccountPO.setUserName();
    }
}
