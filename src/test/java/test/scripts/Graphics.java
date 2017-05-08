package test.scripts;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Graphics {

    private AndroidDriver driver;
    private Wait<WebDriver> wait;

    @Before
    public void startApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0"); //Replace this with your Android version
        caps.setCapability("deviceName", "Android Samsung Galaxy 8"); //Replace this with your simulator/device 
        caps.setCapability("app", "http://appium.github.io/appium/assets/ApiDemos-debug.apk"); //Replace this with app path in your system
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }

    @After
    public void quitApp() {
        driver.quit();
    }

    @Given("^The list of elements in graphics$")
    public void The_list_of_elements_in_graphics() {
        driver.findElementByAccessibilityId("Graphics").click();
    }

    @When("^Click on \"([^\"]*)\" button$")
    public void Click_on_element_button(String arg1) {
        if (arg1.equals("Clipping")) {
            driver.findElementByAccessibilityId("Clipping").click();
        } else if (arg1.equals("Layers")) {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Layers\"))").click();
        } else if (arg1.equals("SensorTest")) {
            List<MobileElement> elements = driver.findElements(By.id("android:id/text1"));
            try {
                while (true) {
                    for (MobileElement element : elements) {
                        if (element.getText().equals("SensorTest")) {
                            element.click();
                            break;
                        }
                    }
                    driver.swipe(500, 1900, 500, 200, 5000);
                }
            } catch (Throwable t) {

            }
        }
    }

    @Then("^I can view a \"([^\"]*)\" image$")
    public void I_can_view_a_element_image(String arg1) {
        Assert.assertEquals(true, driver.findElement(By.xpath("//*[1]//*[1]//*[2]//*[1]")).isDisplayed());
    }
}
