package com.tr.example.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.selectContact();
        app.submitContactDeletion();
        app.acceptAlert();
        app.returnToHomePage();
    }
}
