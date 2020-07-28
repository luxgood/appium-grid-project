import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest2 {

  AppiumDriver driver;

  @FindBy(css = "#catapultCookie")
  WebElement coockieConfirmBtn;

  @FindBy(xpath = "//p[@class='additional-options__item-text' and . = 'Factions']")
  WebElement factionsBtn;

  @BeforeTest
  public void beforeTest() throws MalformedURLException {
    // setup the web driver and launch the webview app.
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    URL url = new URL("http://192.168.8.123:4723/wd/hub");
    driver = new AppiumDriver(url, desiredCapabilities);

    PageFactory.initElements(driver, this);
  }

  @Test
  public void test() {
    driver.get("https://ageofsigmar.com/");
    Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    coockieConfirmBtn.click();
    factionsBtn.click();
  Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
    driver.quit();
  }
}
