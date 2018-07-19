package com.tr.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        app.start();
        app.openSite("http://localhost/addressbook/index.php");
        app.loginSite("admin", "secret");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        app.stop();
    }

}
