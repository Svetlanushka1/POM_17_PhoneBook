package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;

public class AuthenticationScreen extends BaseScreen{
    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement registrationButton;
    //  loginButton -> @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;

    public AuthenticationScreen fillEmail(String email){
        waitElement(editTextEmail, 5);
        type(editTextEmail, email);
        return this;
        //return the object of this class =
        // = stay on the same screen do not go anything
    }
    public AuthenticationScreen fillPassword(String password){
        waitElement(editTextPassword, 5);
        type(editTextPassword, password);
        return this;//stay on the same screen do not go anything
    }

    public ContactListScreen submitLogin(){
        //method that push on the button and return screen Contact list
        loginButton.click();
        return new ContactListScreen(driver);
        //call the method constructor to create new object
    }

    public ContactListScreen login(Auth auth){
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        return new ContactListScreen(driver);
    }




}


