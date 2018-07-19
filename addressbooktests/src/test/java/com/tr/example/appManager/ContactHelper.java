package com.tr.example.appManager;

import com.tr.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    public WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillContactForm(ContactData contact) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contact.getFirstName());

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contact.getLastName());

        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contact.getAddress());
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void submitContactDeletion() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        driver.findElement(By.name("selected[]")).click();
    }

    public int getContactCount() {
    return driver.findElements(By.name("selected[]")).size();
    }
}
