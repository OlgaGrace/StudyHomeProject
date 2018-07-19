package com.tr.example.appManager;

import com.tr.example.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
    public WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData group) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(group.getName());
        //fill group form header
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(group.getHeader());
        //fill group form footer
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(group.getFooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void selectFirstGroup() {
        driver.findElement(By.name("selected[]")).click();

    }

    public void deleteGroup() {
        driver.findElement(By.name("delete")).click();
    }

    public void initGroupModification() {
    driver.findElement(By.name("edit")).click();
    }

    public void confirmGroupModification() {
        driver.findElement(By.name("update")).click();
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}
