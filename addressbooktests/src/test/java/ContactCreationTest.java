import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    private WebDriver driver;



    @Test
    public void testContactCreation() throws Exception {

        initContactCreation();
        fillContactForm("OlgaHome", "SelyavinaHome", "ramat gan");
        submitContactCreation();
    }

    @Test
    public void testContactCreation2() throws Exception {

        initContactCreation();
        fillContactForm("OlgaHome2", "SelyavinaHome2", "ramat gan2");
        submitContactCreation();
    }
}

