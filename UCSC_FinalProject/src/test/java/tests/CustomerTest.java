package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PageFactory;

import static pages.PageFactory.customerPage;

public class CustomerTest extends BaseTest {

    @Test
    public void testCustomerPageFeature() {
        customerPage.visitCustomerPage();
        customerPage.addNewCustomer("John",            // First Name
                "Doe",             // Last Name
                "john.doe@test.com", // Email
                "0112548632",      // Phone Number
                "ABC Corp",        // Company Name
                "ACC123456",       // Account Number
                "Test comment"    // Comments
                    );
        System.out.println("New customer added successfully!");



    }
}
