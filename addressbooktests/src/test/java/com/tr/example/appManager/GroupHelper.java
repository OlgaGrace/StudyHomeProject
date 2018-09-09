package com.tr.example.appManager;

import com.tr.example.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.xpath("//a[contains(text(),'groups')]"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectFirstGroup() {
        click(By.name("selected[]"));

    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void confirmGroupModification() {
        click(By.name("update"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void createAGroup() {
        initGroupCreation();
        fillGroupForm(new GroupData().withName("StudyHome")
                .withHeader("hdr")
                .withFooter("foot"));
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element:elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input"))
                    .getAttribute("value"));
            GroupData group = new GroupData().withName(name)
                    .withId(id);
            groups.add(group);
        }
        return groups;
    }

    public void selectGroupByIndex(int i) {
        driver.findElements(By.name("selected[]")).get(i).click();
    }
}
