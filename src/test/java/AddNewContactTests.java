import config.AppiumConfig;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {
    @BeforeClass
    public void preCondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("haifa@gmail.com")
                .fillPassword("Haifa082022$")
                .submitLogin();

    }
    @Test
            //(invocationCount = 4)//test will be added 4 time
    public void addOneContactPositive(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("Add_" + i )
                .lastName("Positive")
                .email("add_" + i+ "@mail.ru")
                .phone("123456" + i)
                .address("Netanya")
                .description("Add new friend" + i)
                .build();


        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContact()
                .isContactAdded(contact);
    }

    @Test
    public void addOneContactNegativeEmptyPhone(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact = Contact.builder()
                .name("EmptyPhone")
                .lastName("Negative")
                .email("emptyPhone@mail.ru")
                .phone("123456" + i)
                .address("Haifa")
                .description("EmptyPhone")
                .build();

        new ContactListScreen(driver)
                        .openContactForm()
                        .fillContactForm(contact)
                        .submitContactNegative()
                        .isErrorMessageContainsTextAssert("Error")
                ;


    }

    @AfterClass
    public void postCondition(){

    }


}
