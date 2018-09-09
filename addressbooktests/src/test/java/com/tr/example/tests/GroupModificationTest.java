package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){
int before = app.getGroupHelper().getGroupCount();
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("fluentNameModif")
                .withHeader("fluentModifHeader")
                .withFooter("fluentFooterModif"));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        org.testng.Assert.assertEquals(after, before);


    }

    @Test
    public void testGroupModificationByIndex(){
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroupByIndex(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData()
                .withId(before.get(before.size()-1).getId())
                .withName("ANameModifnew2")
                .withHeader("fluentModifHeader")
                .withFooter("fluentFooterModif");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        org.testng.Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(group);

        System.out.println(before);
        System.out.println(after);

        org.testng.Assert.assertEquals(new HashSet(after), new HashSet(before));
    }



}
