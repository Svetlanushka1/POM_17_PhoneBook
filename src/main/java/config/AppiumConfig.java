package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    //webDriver
    //generic for Android and for IOS
    public static AppiumDriver<MobileElement> driver;//fild link to object driver
    /*
    {
  "platformName": "Android",
  "deviceName": "Nex5",
  "platformVersion": "8.0",
  "appPackage": "com.sheygam.contactapp",
  "appActivity": ".SplashActivity"
}
     */
    @BeforeSuite
    public void setUp() throws MalformedURLException {

        //2) method setUp podkluchaet configuration:
        //a. open the session in Appium and
        // b. we podkluchaemsay to the Application correspond to this configuration
        //c. appium takes the run and app starts

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","Nex5");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("appPackage","com.sheygam.contactapp");
        capabilities.setCapability( "appActivity",".SplashActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:\\tools\\apk\\contacts-android.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
    }
    @AfterSuite
    public void tearDawn(){
        driver.quit();

    }

}
