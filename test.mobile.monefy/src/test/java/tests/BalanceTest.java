package tests;

import org.junit.Assert;
import org.junit.Test;

import pageobjects.CategoryPage;
import pageobjects.NewEntryPage;

public class BalanceTest extends BaseTest {

	@Test
	public void addBillsExpense() {
		NewEntryPage newEntry = landingPage.clickExpense();
		
		newEntry.inputEntry("1+4");
		CategoryPage category = newEntry.chooseCategory();
		
		Assert.assertEquals("5", category.getExpenseAmount());
		category.clickCategory("Bills");

		Assert.assertEquals("$0.00", landingPage.getIncomeAmount());
		Assert.assertEquals("$5.00", landingPage.getExpenseAmount());
		Assert.assertEquals("Balance -$5.00", landingPage.getBalanceAmount());
		//TODO check 100% of bill when random category position issue is fixed
	}
	
	@Test
	public void addSalaryIncome() {
		NewEntryPage newEntry = landingPage.clickIncome();
		
		newEntry.inputEntry("1+4");
		CategoryPage category = newEntry.chooseCategory();
		
		Assert.assertEquals("5", category.getExpenseAmount());
		category.clickCategory("Salary");

		Assert.assertEquals("$5.00", landingPage.getIncomeAmount());
		Assert.assertEquals("$0.00", landingPage.getExpenseAmount());
		Assert.assertEquals("Balance $5.00", landingPage.getBalanceAmount());
		//TODO check 100% of bill when random category position issue is fixed
	}
}