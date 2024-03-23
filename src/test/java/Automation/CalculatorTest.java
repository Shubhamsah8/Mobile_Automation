package Automation;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Initialize the AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        System.out.println("Start Automation...");
    }

    @Test
    public void calculation() throws InterruptedException{
        WebElement five = driver.findElement(By.xpath("\t\n" +
                "//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[5]"));
        five.click();
        Thread.sleep(1000);

        WebElement multiply = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"multiply\"]"));
        multiply.click();
        Thread.sleep(1000);

        WebElement nine = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[3]"));
        nine.click();
        Thread.sleep(1000);

        WebElement equals = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]"));
        equals.click();
        Thread.sleep(1000);

    }
}
