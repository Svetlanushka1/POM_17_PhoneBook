import config.AppiumConfig;
import models.Auth;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        // 2. then we go to Auth screen via method gotoAuthenticationScreen
        // 3. then fill email and password
        // 4. push Login Btn
        // 5. Check the title of screen "ContactList"
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin()
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }


    @Test
    public void loginSuccessModel() {
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder()
                        .email("haifa@gmail.com")
                        .password("Haifa082022$")
                        .build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);
    }

   /* @Test
    public void loginNegativeWrongEmail() {
        // 1. we start from new Splash screen
        // 2. go Login form
        // 3. fill with incorrect data
        // 4. click on Login button(Negative - because we stay still on Login screen and do not remove to other screen
        // 5. Intelleige IDEA lines in red the first method which it does not know and stops
        // 6. To right submitLoginNegative we go tp class where submitlogin button is (to Auth screen)
        Assert.assertTrue(new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifagmail.com").fillPassword("Haifa082022$")
                .submitLoginNegative()
                .isErrorMessageText("Login or Password incorrect"));
            }*/
    @Test
    public void wrongPassword() {
        // 1. we start from the Splash screen
        // 2. then we go to Auth screen via method gotoAuthenticationScreen
        // 3. then fill email and password
        // 4. push Login Btn(expext allert)
        // 5. Check the title of screen "ContactList"
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("haifa082022")
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
        //Assert.assertTrue(res);
    }

    @AfterMethod
  public void postCondition() {
       if (new ContactListScreen(driver).isContactListActivityPresent()) {
           new ContactListScreen(driver).logout();
           new SplashScreen(driver);

       }else {
           pause(5);
           driver.navigate().back();

       }

    }

}



