package com.tr.example.tests;

import com.tr.example.appManager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.openqa.selenium.remote.BrowserType;

import java.lang.reflect.Method;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(GroupCreationTest.class);
    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by+"found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }
    }

    @BeforeSuite(alwaysRun = true)

    public void setUp()  {
        app.start();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()  {
        app.stop();
    }

    @BeforeMethod
            public void logTestStart(Method m){
        logger.info("Start "+ m.getName());
    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("Stop "+ m.getName());
    }

}
