package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseScreen {
    public AppiumDriver<MobileElement> driver;
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
        driver.hideKeyboard();//
    }
    public void pause(int time){
        try {
            Thread.sleep(time * 1000);
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
        //the element should have the text
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
        //wait until screed update
    }


    public boolean isDisplayedWithExp(MobileElement element){
        //if element displayed it return true,
        // if not, and we catch Exception,we understand that this is no such element
       try{
           waitElement(element,5);
           return element.isDisplayed();

       } catch(Exception ex){
           return false;
       }


    }

}
