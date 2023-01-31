package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen {
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
    @FindBy(id = "android:id/message")//Error resource-id android:id/alertTitle
    MobileElement allertText;

    @FindBy(id = "android:id/alertTitle")
    MobileElement allertErrorTitle;

    // @FindBy(id = "android:id/button1")
    @FindBy(xpath = "//*[@resource-id = 'android:id/button1']")
    MobileElement okButton;


    public AuthenticationScreen fillEmail(String email) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, email);
        return this;
        //return the object of this class =
        // = stay on the same screen do not go anything
    }

    public AuthenticationScreen fillPassword(String password) {
        waitElement(editTextPassword, 5);
        type(editTextPassword, password);
        return this;//stay on the same screen do not go anything
    }

    public ContactListScreen submitLogin() {
        //method that push on the button and return screen Contact list
        loginButton.click();
        return new ContactListScreen(driver);
        //call the method constructor to create new object
    }

    public ContactListScreen submitRegistration() {
        //method that push on the button and return screen Contact list
        registrationButton.click();
        return new ContactListScreen(driver);
        //call the method constructor to create new object
    }

    public AuthenticationScreen submitRegistrationNegative() {
        //method that push on the button and return screen Contact list
        registrationButton.click();
        return this;

    }

    public ContactListScreen login(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        return new ContactListScreen(driver);
    }
    //?????????????????? negative
    public AuthenticationScreen loginNegative(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        return new AuthenticationScreen(driver);
    }

    public AuthenticationScreen submitLoginNegative() {
        loginButton.click();
        return this;
    }


    public boolean isErrorMessageContainsText(String text){
        boolean res=  false;
        Alert alert = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return res;
    }
    public boolean isAllertTextEqualsError(String text){
        waitElement(allertText,5);
        if(allertText.getText().equals("Error")){
            okButton.click();
            pause(5);
           // driver.navigate().back();
            return true;
        }


        return false;
    }
    public AuthenticationScreen isErrorMessageContainsTextAssert(String text){

       Alert alert = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return this;

    }
    //LoginTests
    public boolean isErrorMessageText(String message) {
        //I should to wait allert
        waitElement(allertText, 5);
        //if I get text from allertText and it contains my text,return true
        if (allertText.getText().contains("Login or Password incorrect")) {
            //I need to click on ok button(find element )
            okButton.click();
            // I need to move to the next screen If I want to run a next test, so I'll say to the driver to move back
            pause(2);
            //move to the back screen
            driver.navigate().back();
            return true;
        }
        return false;
    }
//LoginTests2
    public AuthenticationScreen isErrorMessageTextAssert(String message) {
        //I should to wait allert
        waitElement(allertText, 5);
        //if I get text from allertText and it contains my text,return AuthenticationScreen
        Assert.assertTrue(allertText.getText().contains("Login or Password incorrect"));
        return this;
    }

//AuthNegative

    public boolean isAllertMessageOKBtn(String message) {
         waitElement(allertText, 5);
        if (allertText.getText().contains("Login or Password incorrect")) {
                 okButton.click();
                 return true;
        }
        return false;
    }
    /*
    public AuthenticationScreen isErrorMessageContainsText(String text){
        Alert alert = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return this;
    }
    public ContactListScreen submitContactNegative(){
        //method that push on the button and return screen Contact list
        loginButton.click();
        return this;
    }*/


}


