

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateGroupTest extends TestBase {

    @Test(priority = 2)
    public void testCreateGroupLongName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("header", "footer", "name"));
        app.submitGroupCreation();
        app.returnToGroupPage();
        int after = app.getGroupCount();
        //System.out.println("testCreateGroupLongName() passed");
        Assert.assertEquals(after, before+1);
    }
    @Test(priority = 1)
    public void testCreateGroupShortName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("h", "f", "n"));
        app.submitGroupCreation();
        app.returnToGroupPage();
        int after = app.getGroupCount();
        //System.out.println("testCreateGroupShortName() passed");
        Assert.assertEquals(after, before+1);
    }
    @Test(priority = 3)
    public void testCreateGroupEmpty() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("", "", ""));
        app.submitGroupCreation();
        app.returnToGroupPage();
        int after = app.getGroupCount();
        //System.out.println("testCreateGroupEmpty() passed");
        Assert.assertEquals(after, before+1);
    }
}
