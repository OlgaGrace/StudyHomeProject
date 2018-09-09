package com.tr.example.tests;

import com.tr.example.model.ContactData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTest extends TestBase {
    private WebDriver driver;



    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().goToHomePage();

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        File photo = new File("src/test/resources/photo.jpeg");
        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstName("OlgaHomePicGroup")
                .withLastName("SelyavinaHome")
                .withAddress("ramat gan")
                .withPhoto(photo)
                .withGroup("fluentNameModif"));
        app.getContactHelper().submitContactCreation();

        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void testContactCreation2() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactCreation();
        File photo = new File("src/test/resources/photo.jpeg");
        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstName("OlgaHome2")
                .withLastName("SelyavinaHome2")
                .withAddress("ramat gan2")
        .withPhoto(photo)
        .withGroup("fluentNameModif"));
        app.getContactHelper().submitContactCreation();
    }
}

