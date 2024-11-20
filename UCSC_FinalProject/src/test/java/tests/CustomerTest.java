package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PageFactory;

import static pages.PageFactory.customerPage;

public class CustomerTest extends BaseTest {

    @Test
    public void testCustomerPageFeature() {
        customerPage.visitCustomerPage();
        customerPage.addNewCustomer("Edward",                // First Name
                "Doe",                 // Last Name
                "john.doe@test.com",    // Email
                "0112548632",          // Phone Number
                "123 Main St",         // Address 1
                "Apt 4",               // Address 2
                "New York",            // City
                "NY",                  // Province
                "10001",               // Zip Code
                "USA",                 // Country
                "Test comment",        // Comments
                "Internal notes here", // Internal Notes
                "true",                // Store Account Balance
                "false",               // Credit Limit
                "true",                // Amount to Spend For Next Point
                "false",               // Points
                "ABC Corp",            // Company Name
                "ACC123456",           // Account Number
                "Message to show here" // Message To Show
        );

        // Validate the customer was added by checking for a success message
        String validationError = customerPage.getValidationError();  // Assuming there's an error if something goes wrong
        Assert.assertTrue(validationError.isEmpty(), "Customer was not added successfully!");

        // Print a success message
        System.out.println("New customer added successfully!");
    }

}

