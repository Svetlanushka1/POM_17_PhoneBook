import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.SplashScreen;

public class NegativeAuthTests extends AppiumConfig {


   @Test
    public void emailWithoutPointModel() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .loginNegative(Auth.builder().email("haifa@gmailcom").password("Haifa082022$").build())
                .submitLoginNegative()
                .isAllertMessageOKBtn("Login or Password incorrect");

    }

    @Test
    public void passwordLowCase() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("haifa082022$")
                .submitLoginNegative()
                .isAllertMessageOKBtn("Login or Password incorrect");

    }

    @Test
    public void passwordWithoutDollar() {
        Assert.assertTrue(new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022")
                .submitLoginNegative()
                .isAllertMessageOKBtn("Login or Password incorrect"));

    }
    @Test
    public void registrationWrongEmailNegative(){

        Assert.assertTrue(new AuthenticationScreen(driver)
                .fillEmail("wrong_emaildef.com")
                .fillPassword("$Abcdef12345")
                .submitRegistrationNegative()
                .isAllertTextEqualsError("Error"))
        ;
    }
    @Test
    public void registrationWrongPasswordNegative(){

        new AuthenticationScreen(driver)
                .fillEmail("wrong_emaildef.com")
                .fillPassword("aaabcdef12345")
                .submitRegistrationNegative()
                .isAllertTextEqualsError("Error")
        ;
    }
    @AfterMethod
    public void postCondition() {

        driver.navigate().back();
    }


}
