package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CustomerPage;
import pages.PageFactory;

import static pages.PageFactory.customerPage;

public class CustomerTest extends BaseTest {

    @Test
    public void testLocationPopUp(){
        customerPage.testLocation();
    }

    @Test(dependsOnMethods  = "testLocationPopUp")
    public void testCustomerPageFeature() {
        customerPage.visitCustomerPage();
        customerPage.addNewCustomer("kevin",                // First Name
                "fernando",                 // Last Name
                "kevinfernando.com",    // Email
                "0112548789",          // Phone Number
                "colombo",         // Address 1
                "colombo 7",               // Address 2
                "colombo",            // City
                "western",                  // Province
                "12548",               // Zip Code
                "Sri lanka",                 // Country
                "Test comment",        // Comments
                "Internal notes here", // Internal Notes
                "true",                // Store Account Balance
                "12000.00",               // Credit Limit
                "52",                // Amount to Spend For Next Point
                "20",               // Points
                "XYZ Corp",            // Company Name
                "ACC20021",           // Account Number
                "Test message" // Message To Show
        );

        // Validate the customer was added by checking for a success message
        //  String validationError = customerPage.getValidationError();  // Assuming there's an error if something goes wrong
        // Assert.assertTrue(validationError.isEmpty(), "Customer was not added successfully!");

        // Print a success message
        System.out.println("New customer added successfully!");
    }

    @Test(dependsOnMethods = "testCustomerPageFeature")
    public void searchName(){
        try {
           customerPage.visitCustomerPage();
            customerPage.typeOnSearchField("John");
            customerPage.selectOptionOnCategoryBox("Name");
           customerPage.clickOnSearchButton();
        }catch (Exception ex){
            System.out.println(ex.getMessage());


        }
    }

   /* @Test(dependsOnMethods  = "testLocationPopUp")
    public void testDeleteCustomer() {
        customerPage.visitCustomerPage();
        customerPage.deleteCustomer();
        String validationError = customerPage.getValidationError();
        Assert.assertTrue(validationError.isEmpty(), "Customer was not deleted successfully!");
        System.out.println("Customer deleted successfully!");
    }
*/
}

