package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage {

    //--Visit customer page--
    @FindBy(xpath = "(//a[text()=' Local 2 '])[2]") // Location modal option
    private WebElement location;

    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[3]/a") // Customers tab
    private WebElement customerTab;

    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[3]/ul/li[1]/a") // Customers button in dropdown
    private WebElement customerBtn;

    @FindBy(xpath = "//div[@class = 'nav navbar-nav top-elements navbar-breadcrumb hidden-xs']/a[text()='Customers']")
    // Page validation
    private WebElement validatePage;


    //--Add new customer--
    @FindBy(xpath = "//a[@id='new-person-btn']/span")
    private WebElement newCustomer;

    @FindBy(xpath = "//form[@id='customer_form']/div/div[1]/h3")
    private WebElement customerInfo;

    //--Form Fields--
    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone_number")
    private WebElement phoneNumber;

    @FindBy(id = "company_name")
    private WebElement companyName;

    @FindBy(id = "account_number")
    private WebElement accountNumber;

    @FindBy(id = "comments")
    private WebElement comments;

    //--Dropdowns--
    @FindBy(id = "customer_type")
    private WebElement customerTypeDropdown;

    @FindBy(id = "taxable")
    private WebElement taxableCheckbox;

    //--Additional Fields (e.g., Discount, Pricing Tier)--
    @FindBy(id = "discount_percent")
    private WebElement discountPercent;

    @FindBy(id = "tier_id")
    private WebElement pricingTierDropdown;

    //--Submit Button--
    @FindBy(xpath = "/html/body/div[3]/div[2]/div[3]/div/div[2]/form/div/div[2]/div[13]/input")
    private WebElement saveButton;

    //--Validation Messages--
    @FindBy(xpath = "//span[@class='text-danger']")
    private WebElement validationError;


    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void ignoreLocation() {
        click(location);
    }

    //--Reusable Method to Fill Fields--
    private void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    //--Reusable Method for Dropdown Selection--
    private void selectDropdown(WebElement dropdown, String value) {
        new Select(dropdown).selectByVisibleText(value);
    }

    //--Reusable Method for Checkboxes--
    private void setCheckbox(WebElement checkbox, boolean value) {
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }


    //To visit customer page
    public void visitCustomerPage() {
        // Click the Customers tab
        click(customerTab);

        // Click the Customers button in the dropdown
        click(customerBtn);

        // Validate that the Customers page is loaded
        presenceOfElementLocated(validatePage);
    }

    //--Fill customer Form--
    //--Method to Fill the Entire Customer Form--
    public void fillCustomerForm(String firstName, String lastName, String email, String phoneNumber, String comments, String companyName, String accountNumber) {
        fillField(this.firstName, firstName);
        fillField(this.lastName, lastName);
        fillField(this.email, email);
        fillField(this.phoneNumber, phoneNumber);
        fillField(this.companyName, companyName);
        fillField(this.accountNumber, accountNumber);
        fillField(this.comments, comments);

        //selectDropdown(this.customerTypeDropdown, customerType);
    }

    //--Submit the Form--
    public void submitForm() {
        saveButton.click();
    }

    //--Method to Get Validation Errors--
    public String getValidationError() {
        return validationError.getText();
    }

    //Add new Customer
    public void addNewCustomer(String firstName, String lastName, String email, String phoneNumber, String companyName, String accountNumber, String comments) {
        // Click the "Add New Customer" button
        click(newCustomer);

        // Wait for the form to load
        presenceOfElementLocated(customerInfo);

        // Fill out the form
        fillCustomerForm(firstName, lastName, email, phoneNumber, companyName, accountNumber, comments);

        // Submit the form
        submitForm();
    }


}
