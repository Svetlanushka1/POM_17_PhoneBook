import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfig {
    //1. TestNg checks after/before Test and go to search them to parent class "appiumConfig"
    @Test
    public void launch(){
        //3) constructor that create object SplashScreen starts
        String version = new SplashScreen(driver).getCurrentVersion();
        System.out.println("Version = " + version);
        Assert.assertTrue((version.contains("1.0.0")));
    }

}
