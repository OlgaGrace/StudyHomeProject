package com.tr.example.appManager;

import com.tr.example.model.ContactData;
import com.tr.example.model.GroupData;
import com.tr.example.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private ContactHelper contactHelper;
    public GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    public WebDriver driver;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {

     //   if (browser.equals(BrowserType.CHROME)){
       //     driver = new ChromeDriver();
        //} else if (browser.equals(BrowserType.FIREFOX)){
          //  driver = new FirefoxDriver();
        //}
driver = new EventFiringWebDriver((new ChromeDriver()));
((EventFiringWebDriver) driver).register(new TestBase.MyListener());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        openSite("http://localhost/addressbook/index.php");
        loginSite("admin", "secret");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        contactHelper = new ContactHelper(driver);
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

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
