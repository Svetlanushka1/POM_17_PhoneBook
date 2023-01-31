package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {

        super(driver);
    }
    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement inputName;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement inputLastName;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement inputPhone;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement inputAddress;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement inputDescription;
    @FindBy(id = "com.sheygam.contactapp:id/createBtn")
    MobileElement buttonCreate;

    public AddNewContactScreen fillContactForm(Contact contact){
        waitElement(buttonCreate,10);
        type(inputName,contact.getName());
        type(inputLastName,contact.getLastName());
        type(inputEmail,contact.getEmail());
        type(inputPhone,contact.getPhone());
        type(inputAddress,contact.getAddress());
        type(inputDescription,contact.getDescription());
        return this;
    }

    public ContactListScreen submitContact(){
        buttonCreate.click();
        return new ContactListScreen(driver);
    }
    public ContactListScreen submitContactNegative(){
        buttonCreate.click();
        return new ContactListScreen(driver);
    }


}
