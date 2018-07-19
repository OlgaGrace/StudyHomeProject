package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("modifName", "modifHead", "modifFoot"));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupPage();


    }


}
