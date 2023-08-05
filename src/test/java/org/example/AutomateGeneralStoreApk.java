package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AutomateGeneralStoreApk {
    public AndroidDriver driver;
    @BeforeSuite
    public void driverSetup() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("deviceName", "local");
        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("appPackage", "com.android.dialer");
//        cap.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");
        cap.setCapability("app", fs.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterSuite
    public void quitDriver(){
        driver.removeApp("com.androidsample.generalstore");
        driver.quit();
    }


    @Test
    public void testGeneralStore() throws MalformedURLException, InterruptedException {
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']")).click();
        WebElement name =  driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        name.sendKeys("Habijabi");
        Thread.sleep(2000);
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);
    }

}
