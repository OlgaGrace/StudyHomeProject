package com.tr.example.tests;

import com.tr.example.appManager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        app.start();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        app.stop();
    }

}
