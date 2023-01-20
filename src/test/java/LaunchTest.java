import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchTest extends AppiumConfig {
    @Test
    public void launch(){
        String version = new SplashScreen(driver).getCurrentVersion();
        //create an Object == pass to the ekran
        Assert.assertTrue((version.contains("1.0.0")));

    }

}
