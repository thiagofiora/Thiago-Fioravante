package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CategoryPage {

	private AppiumDriver<MobileElement> driver;

	public CategoryPage() { }

	public CategoryPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "amount_text")
	private MobileElement amount_text;
	
	public void clickCategory(String category) {
		MobileElement category_button = driver.findElement(By.xpath(String.format("//*[@text=\"%s\"]", category)));
		category_button.click();
	}
	
	public String getExpenseAmount() {
		return amount_text.getText();
	}
}
