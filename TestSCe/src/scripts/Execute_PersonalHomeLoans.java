package scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.ANZ_HomeLoan_Calc;

public class Execute_PersonalHomeLoans extends BaseTest{ //Calling Parent class 'BaseTest' as part
                                                         //of Inheritance//

//Defining the TestNG annotation using @Test Method to execute TestNG classes
@Test

public void test_Execute_PersonalHomeLoans() throws InterruptedException, IOException {
ANZ_HomeLoan_Calc Calc=new ANZ_HomeLoan_Calc(driver); //Creating an Object to call/refer the methods
                                                      //from the POM class//

//Calling the below methods for 'Scenario-1' from the POM class 'ANZ_HomeLoan_Calc'//
Calc.AppType_SingleIsSelected();
Calc.NumberofDependants();     
Calc.HomeToLiveInIsSelected();

String Excel_AnnualIncome=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 0);
Calc.getInput_AnnualIncome(Excel_AnnualIncome);
/*In the above script, 'INPUT_PATH' is the path where excel sheet is placed in the framework//
  'Sheet1' is the name of the sheet within the excel where the test data is placed
  1,0 is the row and column mapping where the data is placed in the respective cells.
  Selenium will pick the data and automatically places into the respective fields during the
  run-time.
  'Excel' is the class name which we defined for data-driven tests.
  'getCellValue' is the method defined in the Excel class.
  */

String Excel_OtherIncome=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 1);
Calc.getInput_OtherIncome(Excel_OtherIncome);

String Excel_MonthlyLiving_Expense=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 2);
Calc.getInput_MonthlyLivingExpense(Excel_MonthlyLiving_Expense);

String Excel_OtherLoan_MonthlyRepayments=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 3);
Calc.getInput_OtherLoan_MonthlyRepayments(Excel_OtherLoan_MonthlyRepayments);

String Excel_TotalCreditCard_Limits=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 4);
Calc.getInput_TotalCreditCard_Limits(Excel_TotalCreditCard_Limits);

Calc.click_WorkoutHowMuchicouldborrow_Button();
Calc.capture_EstimatedAmount();

//Calling 'Scenario-2' methods from the POM class://
Calc.clickButton_StartOver();


//Calling and executing 'Scenario-3' methods from POM class. Here Living expense will take $1//
//Clicks on the button with Living expense filled with $1 and remaining ones as 0//
String Excel_MonthlyLiving_Expense$1=Excel.getCellValue(INPUT_PATH, "Sheet1", 1, 5);
Calc.getInput_MonthlyLivingExpense(Excel_MonthlyLiving_Expense$1);
Calc.click_WorkoutHowMuchicouldborrow_Button();
Calc.capture_ReturnedMessage();

}
}
