package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends BasePage {

    //--Visit customer page--
    @FindBy(xpath = "//div[@id='choose_location_modal']/div/div/div[2]/ul/li[1]/a") // Location modal option
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
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='phone_number']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='address_1']")
    private WebElement address01;

    @FindBy(xpath = "//input[@id='address_2']")
    private WebElement address02;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement province;

    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//textarea[@id='comments']")
    private WebElement comments;

    @FindBy(xpath = "//textarea[@id='internal_notes']")
    private WebElement internalNotes;

    @FindBy(xpath = "//input[@id='balance']")
    private WebElement storeAccountBalance;

    @FindBy(xpath = "//input[@id='credit_limit']")
    private WebElement creditLimit;

    @FindBy(xpath = "//input[@id='amount_to_spend_for_next_point']")
    private WebElement amountToSpendForNextPoint;

    @FindBy(xpath = "//input[@id='points']")
    private WebElement points;

    @FindBy(xpath = "//input[@id='company_name']")
    private WebElement companyName;

    @FindBy(xpath = "//input[@id='account_number']")
    private WebElement accountNumber;

    @FindBy(xpath = "//textarea[@id='customer_info_popup']")
    private WebElement messageToShow;


    //--Dropdowns--
    @FindBy(xpath = "//select[@id='section_names']")
    private WebElement terms;

    @FindBy(id = "tier_id")
    private WebElement tierType;

    //--Submit Button--
    @FindBy(xpath = "(//input[@id='submitf'])[1]")
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
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    //--Reusable Method for Checkboxes--
    private void setCheckbox(WebElement checkbox, boolean value) {
        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }


    // To visit customer page
    public void visitCustomerPage() {
        ignoreLocation();
        // Click the Customers tab
        click(customerTab);

        // Click the Customers button in the dropdown
        click(customerBtn);

        // Validate that the Customers page is loaded
        presenceOfElementLocated(validatePage);
    }

    //--Fill customer Form--
    //--Method to Fill the Entire Customer Form--
    public void fillCustomerForm(String firstName, String lastName, String email, String phoneNumber, String address01, String address02,
                                 String city, String province, String zip, String country, String comments, String internalNotes,
                                 String storeAccountBalance, String creditLimit, String amountToSpendForNextPoint,
                                 String points, String companyName, String accountNumber, String messageToShow, String toShow) {

        // Fill all text fields
        fillField(this.firstName, firstName);
        fillField(this.lastName, lastName);
        fillField(this.email, email);
        fillField(this.phoneNumber, phoneNumber);
        fillField(this.address01, address01);
        fillField(this.address02, address02);
        fillField(this.city, city);
        fillField(this.province, province);
        fillField(this.zip, zip);
        fillField(this.country, country);
        fillField(this.comments, comments);
        fillField(this.internalNotes, internalNotes);
        fillField(this.storeAccountBalance, storeAccountBalance);
        fillField(this.creditLimit, creditLimit);
        fillField(this.amountToSpendForNextPoint, amountToSpendForNextPoint);
        fillField(this.points, points);
        fillField(this.companyName, companyName);
        fillField(this.accountNumber, accountNumber);
        fillField(this.messageToShow, messageToShow);

        // Handling the "Terms" dropdown

    }

    //--Submit the Form--
    public void submitForm() {
        saveButton.click();
    }

    //--Method to Get Validation Errors--
    public String getValidationError() {
        return validationError.getText();
    }

    // Add new Customer
    public void addNewCustomer(String firstName, String lastName, String email, String phoneNumber, String address01, String address02,
                               String city, String province, String zip, String country, String comments, String internalNotes,
                               String storeAccountBalance, String creditLimit, String amountToSpendForNextPoint,
                               String points, String companyName, String accountNumber, String messageToShow) {
        // Click the "Add New Customer" button
        click(newCustomer);

        // Wait for the form to load
        presenceOfElementLocated(customerInfo);

        // Fill out the form
        fillCustomerForm(firstName, lastName, email, phoneNumber, companyName, address01, address02, city, province, zip, country,
                comments, internalNotes, storeAccountBalance, creditLimit, amountToSpendForNextPoint, points, companyName,
                accountNumber, messageToShow);

        // Submit the form
        submitForm();
    }
}
