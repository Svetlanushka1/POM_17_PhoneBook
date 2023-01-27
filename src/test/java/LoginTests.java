import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess() {
        // 1. we start from the Splash screen
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin()
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }
    public AuthenticationScreen gotoAuthenticationScreen()
    {//2. then we pass to Auth screen via method gotoAuthenticationScreen
        return  new AuthenticationScreen(driver);
     //3. then fill email and password
    }
    @Test
    public void loginSuccessModel() {
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder().email("haifa@gmail.com").password("Haifa082022$").build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }

    @AfterMethod
    public void postCondition() {
        if (new ContactListScreen(driver).isContactListActivityPresent()) {
            new ContactListScreen(driver).logout();
            new SplashScreen(driver);
        }
    }


}
