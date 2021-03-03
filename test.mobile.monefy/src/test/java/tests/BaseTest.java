package tests;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageobjects.LandingPage;

public class BaseTest {
	
	static AppiumDriver<MobileElement> driver;
	protected static LandingPage landingPage;
	static DesiredCapabilities caps;

	@BeforeClass
	public static void setupClass() {
		
		caps = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3a");
		caps.setCapability("appPackage", "com.monefy.app.lite");
		caps.setCapability("appActivity", "com.monefy.activities.main.MainActivity_");
		caps.setCapability("automationName", "UiAutomator2");
		Path resourceDirectory = Paths.get("src","test","resources");
		caps.setCapability(MobileCapabilityType.APP, resourceDirectory.toFile().getAbsolutePath() + "\\app\\com.monefy.app.lite_2021-02-01.apk");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	}
	
	@Before
	public void setup() {
		
		driver = new AppiumDriver<MobileElement>(caps);
		landingPage = new LandingPage(driver);
		landingPage.cleanTourBaloons();
	}
	
	@After
	public void teardown() {
		
		if (driver != null)
			driver.quit();
	}
}



