package com.tr.example.appManager;

import com.tr.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver driver) {
        super(driver);
    }


    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAddress());
      //  attach(By.name("photo"), contact.getPhoto());
     //   new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroup());
    }



    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public int getContactCount() {
    return driver.findElements(By.name("selected[]")).size();
    }
}
