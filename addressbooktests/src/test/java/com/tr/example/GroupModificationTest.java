package com.tr.example;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){

        app.goToGroupPage();
        app.selectFirstGroup();
        app.initGroupModification();
        app.fillGroupForm(new GroupData("modifName", "modifHead", "modifFoot"));
        app.confirmGroupModification();
        app.returnToGroupPage();


    }


}
