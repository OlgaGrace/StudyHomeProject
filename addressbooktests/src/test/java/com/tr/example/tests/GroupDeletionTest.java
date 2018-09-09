package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion(){

        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createAGroup();
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        org.testng.Assert.assertEquals(after, before-1);
    }
@Test
    public void testGroupDeletionByIndex(){
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createAGroup();
        }
    List<GroupData> before = app.getGroupHelper().getGroupList();
     //   int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroupByIndex(before.size()-1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
     //   int after = app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGroupList();
        org.testng.Assert.assertEquals(after.size(), before.size()-1);
        before.remove(before.size()-1);
        Assert.assertEquals(before,after);
    }



}
