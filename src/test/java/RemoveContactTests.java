import config.AppiumConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactTests extends AppiumConfig {
    @BeforeClass
    public void preCondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin();
        /* AuthModel
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder()
                        .email("haifa@gmail.com")
                        .password("Haifa082022$")
                        .build())
                .isContactListActivityPresentAssert()
        */

    }
    @Test
    public void removeOneContactPositive(){
        //my actions start form ContactListScreen
        new ContactListScreen(driver)
                .removeOneContact();
    }
}
