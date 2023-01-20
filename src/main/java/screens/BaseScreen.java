package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;
// generate constructor
    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        //add class for initilisation which calls
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
}
