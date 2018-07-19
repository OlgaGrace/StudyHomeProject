package com.tr.example.tests;

import com.tr.example.model.ContactData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    private WebDriver driver;



    @Test
    public void testContactCreation() throws Exception {

        int before = app.getContactCount();
        app.initContactCreation();
        app.fillContactForm(new ContactData("OlgaHome", "SelyavinaHome", "ramat gan"));
        app.submitContactCreation();
        int after = app.getContactCount();
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void testContactCreation2() throws Exception {

        app.initContactCreation();
        app.fillContactForm(new ContactData("OlgaHome2", "SelyavinaHome2", "ramat gan2"));
        app.submitContactCreation();
    }
}

