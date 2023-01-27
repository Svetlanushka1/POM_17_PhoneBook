package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;
// generate constructor
    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        //add class for inicilisation which calls
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
    public void type(MobileElement element, String text){
                   //locator to mobile element and text to type
        if(text == null)return;
        element.clear();
        element.clear();
        element.sendKeys(text);
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //print to console error
        }
    }
    public void waitElement(MobileElement element, int time){
        //is element present on the screen
        new WebDriverWait(driver,time).until(
                ExpectedConditions.visibilityOf(element));
    }
    public boolean shouldHave(MobileElement element, String text, int time){
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
