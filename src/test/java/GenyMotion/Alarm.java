package GenyMotion;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Alarm {
    public AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "169.254.147.101:5555");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("appPackage", "com.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");

        // Initialize the AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void setAlarm() {

        WebElement alarm = driver.findElement(By.xpath("\t\n" +
                "//android.widget.LinearLayout[@content-desc=\"Alarm\"]/android.widget.TextView"));
        alarm.click();

        WebElement settingAlarm = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"8:30 AM Alarm\"]"));
        settingAlarm.click();

        WebElement enable = driver.findElement(By.xpath("\t\n" +
                "//android.view.ViewGroup[@content-desc=\"8:30 AM Alarm\"]/android.widget.Switch"));
        enable.click();
    }
}
