package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewEntryPage {
	
	private AppiumDriver<MobileElement> driver;
	
	public NewEntryPage() { }
	
	public NewEntryPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "keyboard_action_button")
	private MobileElement category_button;

	@AndroidFindBy(id = "buttonKeyboard0")
	private MobileElement zero_button;

	@AndroidFindBy(id = "buttonKeyboard1")
	private MobileElement one_button;
	
	@AndroidFindBy(id = "buttonKeyboard2")
	private MobileElement two_button;

	@AndroidFindBy(id = "buttonKeyboard3")
	private MobileElement three_button;
	
	@AndroidFindBy(id = "buttonKeyboard4")
	private MobileElement four_button;

	@AndroidFindBy(id = "buttonKeyboardPlus")
	private MobileElement plus_button;
	
	@AndroidFindBy(id = "buttonKeyboardMinus")
	private MobileElement minus_button;

	@AndroidFindBy(id = "buttonKeyboardEquals")
	private MobileElement equals_button;
	
		
	public void inputEntry(String expression) {
		
		for (String key : expression.split("")) {
			if (key.equals("0")) {
				zero_button.click();
			} else if(key.equals("1")) {
				one_button.click();
			} else if(key.equals("2")) {
				two_button.click();
			} else if(key.equals("3")) {
				three_button.click();
			} else if(key.equals("4")) {
				four_button.click();
			} else if(key.equals("+")) {
				plus_button.click();
			} else if(key.equals("-")) {
				minus_button.click();
			} else if(key.equals("=")) {
				equals_button.click();
			}
		}
		equals_button.click();
	}
	
	public CategoryPage chooseCategory() {
		category_button.click();
		return new CategoryPage(driver);
	}
}
