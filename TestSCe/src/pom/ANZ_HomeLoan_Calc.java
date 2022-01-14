package pom;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

//Creating the below POM (Page Object Model) class for driving the Page objects in the Framework//
public class ANZ_HomeLoan_Calc extends BasePage{ //Calling Parent class 'BasePage' to Child class//
	                                             //'Inheritance' concept is used here in Framework//

/*Note: Locators and their path/location in the HTML tree is picked and mapped from the given URL:
https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow
All the 'Relative Xpaths' are derived, mapped and scripted into the xpaths*/

//Defining the WebElements that needs to perform action on each element using 'FindBy' annotation//

//Declaring the WebElement/Field 'Single'//
@FindBy(xpath="//input[@id='application_type_single']")
private WebElement AppType_Single;

//Declaring 'Number of Dependants' Drop-down field//
@FindBy(xpath="//select[@title='Number of dependants']")
private WebElement Number_ofDependants;

//Declaring the element 'Home to live in'//
@FindBy(xpath="//input[@id='borrow_type_home']")
private WebElement HomeToLiveIn;

//Declaring the element 'Your Annual Income'//
@FindBy(xpath="//input[@aria-labelledby='q2q1']")
private WebElement AnnualIncome;

//Declaring the element 'Other Income'//
@FindBy(xpath="//input[@aria-labelledby='q2q2']")
private WebElement OtherIncome;

//Declaring Monthly living expense//
@FindBy(xpath="//input[@aria-labelledby='q3q1']")
private WebElement MonthlyLiving_Expense;

//Declaring Current Home Loan Monthly Repayments//
@FindBy(xpath="//input[@aria-labelledby='q3q2']")
private WebElement CurrentHomeLoan_Repayments;

//Declaring Other loan monthly repayments//
@FindBy(xpath="//input[@aria-labelledby='q3q3']")
private WebElement OtherLoan_MonthlyRepayments;

//Declaring Other monthly commitments//
@FindBy(xpath="//input[@aria-labelledby='q3q4']")
private WebElement Other_MonthlyCommitments;

//Declaring Total credit limits//
@FindBy(xpath="//input[@aria-labelledby='q3q5']")
private WebElement TotalCreditCard_Limits;

//Declaring the element for 'Work out How Much i could borrow' button//
@FindBy(xpath="//button[@id='btnBorrowCalculater']")
private WebElement ClickButton_WorkoutHowMuch;

//Declaring the element to capture 'Estimate Amount'//
@FindBy(xpath="//span[@id='borrowResultTextAmount']")
private WebElement Capture_EstimateAmount;

//Declaring the Start over button field//
@FindBy(xpath="(//button[@class='start-over'])[1]")
private WebElement Button_StartOver;

//Declaring the element to capture the return message displayed to the user//
@FindBy(xpath="//div[@class='borrow__error__text']")
private WebElement Capture_RetunMessage;

public ANZ_HomeLoan_Calc(WebDriver driver) {
super(driver);
}

/*Scenario1: Below method to verify/check the Application Type 'Single' is selected by default. 
If Single is not selected, we fail the test script using Assert.fail() condition as below*/

public void AppType_SingleIsSelected() {
	boolean applicationtype_Single=AppType_Single.isSelected();
	if(applicationtype_Single==true) {
		Reporter.log("Application Type 'Single' is selected", true);
		//System.out.println("Single is selected");
	}
	else {
		Reporter.log("Application Type 'Single' is Not selected", true);
		Assert.fail(); //Condition fails using Assert class if condition is not matching//
		//System.out.println("Single is not selected");
	}
	}


/*Scenario1: Below method to verify Drop-down with 'Number of Dependants' to select '0'
 Using 'Select' class*/

public void NumberofDependants() {
	WebElement menu=Number_ofDependants;
	Select select=new Select(menu); //Select class is implemented here//
	select.selectByIndex(0);//This selects the first element/object from the Drop-down as Index
	                        //starts from 0 in Selenium//
}


/*Scenario1: Below method to verify/check the 'Home to live in' is selected. 
If Home to live in is not selected, we fail the test script using Assert.fail() condition as below*/

public void HomeToLiveInIsSelected() {
	boolean Button_Hometolivein=HomeToLiveIn.isSelected();
	if(Button_Hometolivein==true) {
		Reporter.log("Home to live in' is selected", true);
			}
	else {
		Reporter.log("Home to live in' is Not selected", true);
		Assert.fail(); //Condition fails using Assert class if condition is not matching//
			}
	}

//Scenario 1:Below method to get Input for 'Annual Income' field//
public void getInput_AnnualIncome(String InpAnnualIncome) throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='q2q1']")));
	AnnualIncome.sendKeys(InpAnnualIncome);
	}

//Scenario 1:Below method to get Input for 'Other Income' field//
public void getInput_OtherIncome(String InpOtherIncome) {
	WebDriverWait wait=new WebDriverWait(driver, 2);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='q2q2']")));
	OtherIncome.sendKeys(InpOtherIncome);
}

//Scenario 1: Below method to get Input for 'Monthly living expense' field//
public void getInput_MonthlyLivingExpense(String InpMonthlyExpense) throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, 2);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='q3q1']")));
	MonthlyLiving_Expense.sendKeys(InpMonthlyExpense);
	//Thread.sleep(2000);
}

//Scenario 1: Below method to get Input for 'Other Loan Monthly Repayments' field//
public void getInput_OtherLoan_MonthlyRepayments(String InpOtherLoan_MonthlyRepayments) {
	WebDriverWait wait=new WebDriverWait(driver, 2);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='q3q3']")));
	OtherLoan_MonthlyRepayments.sendKeys(InpOtherLoan_MonthlyRepayments);
}

//Scenario 1: Below method to get Input for 'Total Credit card limits' field//
public void getInput_TotalCreditCard_Limits(String InpTotalCreditCard_Limits) {
	WebDriverWait wait=new WebDriverWait(driver, 2);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='q3q5']")));
	TotalCreditCard_Limits.sendKeys(InpTotalCreditCard_Limits);
	((JavascriptExecutor)driver).executeScript("scroll(0,500)");
}

//Scenario 1: Below method to click on 'Work out How Much i could borrow' button//
public void click_WorkoutHowMuchicouldborrow_Button() throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, 2);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnBorrowCalculater']")));
	ClickButton_WorkoutHowMuch.click();
	Thread.sleep(2000);
}

//Scenario 1: Below method to capture the 'Total Estimated Amount'//
public void capture_EstimatedAmount() throws IOException {
	String actual_EstimatedAmount=Capture_EstimateAmount.getText();
	String expected_EstimatedAmount="$482,000";
	Assert.assertEquals(actual_EstimatedAmount, expected_EstimatedAmount);/*Assert condition is
	implemented to verify the actual and the exact expected estimated total amount. If expected 
	total amount is not matching, then scripts fails. If the expected amount displayed matches
	then the script gets passed*/
Reporter.log(actual_EstimatedAmount, true); //This script prints the exact amount in console//
	
//Below script to capture the exact values entered as per the requirement and also captures//
//Total estimated amount//
	File scrFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(scrFile1, new File("./Screenshots/Scenario1_Capture_TotalEstimated_LoanAmount.png"));
	
}

//Scenario-2: clicking on 'Start Over' button clears the form/fields in the home loan page//
public void clickButton_StartOver() throws IOException {
	Button_StartOver.click(); //Script clicks on the given button//
	
	//Below script to show that all fields are cleared once user clicks on Start over button//
	File scrFile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(scrFile2, new File("./Screenshots/Scenario2_Capture_AllFields_Cleared.png"));
}

/*Scenario-3: Method to capture the exact return message once user clicks on the button
'Work out How Much i could borrow' considering the scenario only the Living expense field is
filled with $1 and remaining fields with 0 values*/
public void capture_ReturnedMessage() throws IOException {
((JavascriptExecutor)driver).executeScript("scroll(0,500)");
String acutal_ReturnedMessage=Capture_RetunMessage.getText(); //Using getText() method, we are
//capturing the message that is displayed to the user on clicking the button//
String expected_ReturnedMessage="Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
Assert.assertEquals(acutal_ReturnedMessage, expected_ReturnedMessage);
Reporter.log(acutal_ReturnedMessage, true);
//Assert condition is also implemented above to check the validity of the message displayed//

//Script imposed to capture the exact returned message//
File scrFile3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileHandler.copy(scrFile3, new File("./Screenshots/Scenario3_Capture_ReturnedMessage.png"));

}

/*End of script for this POM*/
}

