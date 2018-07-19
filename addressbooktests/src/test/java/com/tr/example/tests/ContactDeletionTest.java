package com.tr.example.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletion();
        app.acceptAlert();
        app.returnToHomePage();
    }
}

