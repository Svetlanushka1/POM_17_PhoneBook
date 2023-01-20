import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class SplashScreen extends BaseScreen {
    //annotation FindBy

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/version_text']")
    MobileElement versionTextView;

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    public String getCurrentVersion(){
        return versionTextView.getText();
    }

}
