package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation()  {

        app.goToGroupPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("StudyHome", "header", "footer"));
        app.submitGroupCreation();
        app.returnToGroupPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after, before+1);
    }

}
