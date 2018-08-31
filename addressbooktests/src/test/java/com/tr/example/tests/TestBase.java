package com.tr.example.tests;

import com.tr.example.appManager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite(alwaysRun = true)
    public void setUp()  {
        app.start();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()  {
        app.stop();
    }

}
