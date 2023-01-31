package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;


public class SplashScreen extends BaseScreen {
    //annotation FindBy

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/version_text']")
    MobileElement versionTextView;

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        //3) method "launch " :
        // the constructor (there is the description of the SlashScreen in it)
        // that creates the object SplashScreen starts
        super(driver);
        //constructor calls the Base screen's constructor (his parent)
        //that call the method "initElements" which read all elements on the page
        //and builds elements' tree of the page and return to Launch test

    }
    public String getCurrentVersion(){

        return versionTextView.getText();
    }

    public AuthenticationScreen gotoAuthenticationScreen()
    {//2. then we pass to Auth screen via method gotoAuthenticationScreen
        return  new AuthenticationScreen(driver);

    }

}
