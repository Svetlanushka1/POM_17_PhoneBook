package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ContactListScreen extends BaseScreen {
    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOption;
    @FindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    MobileElement plusButton;
    @FindBy(id = "com.sheygam.contactapp:id/title")
    MobileElement logoutButton;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;
    @FindBy(id = "android:id/button1")
    MobileElement yesButton;



    @FindBy(id = "com.sheygam.contactapp:id/rowName")
    List<MobileElement> names;
    @FindBy(id = "com.sheygam.contactapp:id/rowPhone")
    List<MobileElement> phones;
    @FindBy(id = "com.sheygam.contactapp:id/rowContainer")
    List<MobileElement> contacts;

    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    public boolean isContactListActivityPresent() {
        shouldHave(activityViewText, "Contact list", 5);
        return true;
    }
    //boolean+Assert
    public ContactListScreen isContactListActivityPresentAssert() {
        shouldHave(activityViewText, "Contact list", 5);
        Assert.assertTrue(activityViewText.getText().contains("Contact list"));
        return this;
    }
/*
 public SearchScreen isSearchScreenDisplaeydAssert(){
        should(titlePage,5);
       Assert.assertTrue(titlePage.getText().equals("Find your car now!"));
        return this;
    }
 */
    public AuthenticationScreen logout() {
        if(isDisplayedWithExp(moreOption)){
            moreOption.click();
            logoutButton.click();
        }
        return new AuthenticationScreen(driver);
    }

    public AddNewContactScreen openContactForm(){
        waitElement(plusButton, 10);
        plusButton.click();
        return new AddNewContactScreen(driver);
    }

    public ContactListScreen isContactAdded(Contact contact){
        boolean checkName = checkContainsText(names, contact.getName());
        boolean checkPhone = checkContainsText(phones, contact.getPhone());
        Assert.assertTrue(checkPhone&&checkName);
        return this;
    }


    public boolean checkContainsText(List<MobileElement> list, String text){
        for (MobileElement e : list){
            if(e.getText().contains(text)){
                return true;
            }
        }
        return false;
    }

    public ContactListScreen removeOneContact(){
        waitElement(plusButton, 5);
        MobileElement contact = contacts.get(0);
        System.out.println("Length = " + contacts.size());
        Rectangle rect = contact.getRect();

        int xStart = rect.getX() + rect.getWidth() / 8;
        int xEnd = xStart + (rect.getWidth() * 6) / 8;
        int y = rect.getY() + rect.getHeight() / 2;
        System.out.println(xStart + "\n" + xEnd + "\n" + y);

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xStart, y))
                .moveTo(PointOption.point(xEnd, y))
                .release()
                .perform();
        yesButton.click();
        pause(5);
        return this;
    }

    public ContactListScreen isErrorMessageContainsTextAssert(String text){

        Alert alert = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return this;

    }


}
