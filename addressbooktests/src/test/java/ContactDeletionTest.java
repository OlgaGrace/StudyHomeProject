import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        selectContact();
        submitContactDeletion();
        acceptAlert();
        returnToHomePage();
    }
}

