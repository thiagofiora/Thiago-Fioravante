package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage {

	private AppiumDriver<MobileElement> driver;
	
	public LandingPage() { }
	
	public LandingPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "income_button_title")
	private MobileElement income_button;
	
	@AndroidFindBy(id = "expense_button_title")
	private MobileElement expense_button;
	
	@AndroidFindBy(id = "balance_amount")
	private MobileElement balance_amount;
	
	@AndroidFindBy(id = "expense_amount_text")
	private MobileElement expense_amount_text;
	
	@AndroidFindBy(id = "income_amount_text")
	private MobileElement income_amount_text;
	
	public NewEntryPage clickExpense() {
		expense_button.click();
		return new NewEntryPage(driver);
	}
	
	public NewEntryPage clickIncome() {
		income_button.click();
		return new NewEntryPage(driver);
	}
	
	public String getBalanceAmount() {
		return balance_amount.getText();
	}
	
	public String getExpenseAmount() {
		return expense_amount_text.getText();
	}
	
	public String getIncomeAmount() {
		return income_amount_text.getText();
	}
}
