package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroupLongName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().withName("name").withHeader("header").withFooter("footer"));
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
