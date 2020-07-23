import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {


    @Test
    public void test() throws MalformedURLException {
        //setup the web driver and launch the webview app.
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        URL url = new URL("http://192.168.8.123:4723/wd/hub");
        AppiumDriver driver = new AppiumDriver(url, desiredCapabilities);

// Navigate to the page and interact with the elements on the guinea-pig page using id.
        driver.get("http://saucelabs.com/test/guinea-pig");
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        WebElement div = driver.findElement(By.cssSelector("#i_am_an_id"));
        Assert.assertEquals("I am a div", div.getText()); //check the text retrieved matches expected value
        driver.findElement(By.cssSelector("#comments")).sendKeys("My comment"); //populate the comments field by id.

//close the app.
        driver.quit();

    }
}
