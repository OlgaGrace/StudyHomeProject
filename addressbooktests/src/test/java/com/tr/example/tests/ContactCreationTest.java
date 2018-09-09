package com.tr.example.tests;

import com.tr.example.model.ContactData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File
                        ("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withFirstName(split[0])
                    .withLastName(split[1])
                    .withFirstName(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    private WebDriver driver;



    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactData group) throws Exception {
        app.getNavigationHelper().goToHomePage();

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
       // File photo = new File("src/test/resources/photo.jpeg");
        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstName(group.getFirstName())
                .withLastName(group.getLastName())
                .withAddress(group.getAddress()));
              //  .withPhoto(photo)
         //       .withGroup("fluentNameModif"));
        app.getContactHelper().submitContactCreation();

        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void testContactCreation2() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactCreation();
      //  File photo = new File("src/test/resources/photo.jpeg");
        app.getContactHelper().fillContactForm(new ContactData()
                .withFirstName("OlgaHome2")
                .withLastName("SelyavinaHome2")
                .withAddress("ramat gan2"));
       // .withPhoto(photo)
     //   .withGroup("fluentNameModif"));
        app.getContactHelper().submitContactCreation();
    }
}

