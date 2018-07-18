import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        openSite("http://localhost/addressbook/index.php");
        loginSite("admin", "secret");
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(String name, String header, String footer) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(name);
        //fill group form header
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(header);
        //fill group form footer
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(footer);
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void loginSite(String username, String pwd) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(pwd);
        //submit login
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void openSite(String url) {
        driver.get(url);
    }
    public void selectFirstGroup() {
        driver.findElement(By.name("selected[]")).click();

    }
    public void deleteGroup() {
        driver.findElement(By.name("delete")).click();
    }
    public void initGroupModification() {
    driver.findElement(By.name("edit")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void confirmGroupModification() {
        driver.findElement(By.name("update")).click();
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillContactForm(String firstName, String lastName, String address) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastName);

        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void returnToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    protected void submitContactDeletion() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    protected void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }
}
