package com.tr.example.tests;

import com.tr.example.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator <Object[]> validGroups() throws IOException {
        List <Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split = line.split(";");
            list.add(new Object[] {new GroupData()
                    .withName(split[0])
                    .withHeader(split[1])
                    .withFooter(split[2])});
            line = reader.readLine();
        }
return list.iterator();

    }


    @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupData group)  {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName(group.getName())
        .withHeader(group.getHeader())
        .withFooter(group.getFooter()));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before+1);

    }

    @Test
    public void testGroupCreationIndex()  {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
     //   int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        GroupData groupdva = new GroupData().withName("new");
        app.getGroupHelper().fillGroupForm(groupdva);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
      //  int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size()+1);

        int max = 0;
        for (GroupData g: after){
            if (g.getId()>max){
                max = g.getId();
            }
        }
groupdva.withId(max);
        before.add(groupdva);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }

}
