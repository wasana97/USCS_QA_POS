package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupplierPage extends BasePage{
    @FindBy(xpath = "//span[text()='Suppliers']")
    private WebElement suppliersTab;

    @FindBy(xpath = "//span[text()=' New Supplier']")
    private WebElement newSupplier;

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement companyName;

    @FindBy(xpath = "(//input[@id='submitf'])[1]")
    private WebElement saveBtn;


    public SupplierPage(WebDriver driver) {
        super(driver);
    }

    public void visitSupplierPage(){
        suppliersTab.click();
    }

    public void addNewSupplier(){
        newSupplier.click();
        companyName.sendKeys("ABC");
        saveBtn.click();
    }

}
