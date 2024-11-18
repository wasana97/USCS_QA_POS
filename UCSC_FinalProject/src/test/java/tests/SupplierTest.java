package tests;

import org.testng.annotations.Test;
import pages.PageFactory;

public class SupplierTest extends BaseTest {
    @Test
    public void testSupplier() {
        PageFactory.supplierPage.visitSupplierPage();
      //  PageFactory.supplierPage.addNewSupplier();
    }

}
