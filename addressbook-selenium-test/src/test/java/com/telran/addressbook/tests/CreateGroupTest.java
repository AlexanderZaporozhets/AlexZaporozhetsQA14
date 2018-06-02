package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateGroupTest extends TestBase {
    @DataProvider
    public Iterator<Object[]>validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroupLongName(GroupData group) throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().withName(group.getName()).withHeader(group.getHeader()).withFooter(group.getFooter()));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testCreateGroupLongName() passed");
        Assert.assertEquals(after, before+1);
    }
    @Test
    public void testCreateGroupShortName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().withName("h").withHeader("f").withFooter("n"));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testCreateGroupShortName() passed");
        Assert.assertEquals(after, before+1);
    }
    @Test
    public void testCreateGroupEmpty() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().withName("").withHeader("").withFooter(""));
        app.getGroupHelper().submitGroupCreation(By.name("submit"));
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testCreateGroupEmpty() passed");
        Assert.assertEquals(after, before+1);
    }
}
