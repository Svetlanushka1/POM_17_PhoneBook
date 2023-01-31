import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;





public class LoginTests2 extends AppiumConfig {

    @Test
    public void loginSuccess() {
        // 1. we start from the Splash screen
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin()
                .isContactListActivityPresentAssert()
                .logout()
        ;

    }

    @Test
    public void loginSuccessModel() {
     new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder()
                        .email("haifa@gmail.com")
                        .password("Haifa082022$")
                        .build())
                .isContactListActivityPresentAssert()
             .logout();
    }

    @Test
    public void loginNegativeWrongEmail() {
        // 1. we start from new Splash screen
        // 2. go Login form
        // 3. fill with incorrect data
        // 4. click on Login button(Negative - because we stay still on Login screen and do not remove to other screen
        // 5. Intelleige IDEA lines in red the first method which it does not know and stops
        // 6. To right submitLoginNegative we go tp class where submitlogin button is (to Auth screen)
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifagmail.com").fillPassword("Haifa082022$")
                .submitLoginNegative()
                .isErrorMessageTextAssert("Login or Password incorrect")
                .driver.navigate().back();
            }
    @Test
    public void loginNegativeWrongPassword() {
               new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com").fillPassword("H" +
                               "haifa082022$")
                .submitLoginNegative()
                .isErrorMessageTextAssert("Login or Password incorrect")
                .driver.navigate().back();
    }

}



