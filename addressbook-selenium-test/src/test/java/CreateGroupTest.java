

import org.testng.annotations.*;

public class CreateGroupTest extends TestBase {

    @Test(priority = 2)
    public void testCreateGroupLongName() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("name", "header", "footer");
        submitGroupCreation();
        returnToGroupPage();
        System.out.println("testCreateGroupLongName() passed");
    }
    @Test(priority = 1)
    public void testCreateGroupShortName() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("n", "h", "f");
        submitGroupCreation();
        returnToGroupPage();
        System.out.println("testCreateGroupShortName() passed");
    }
    @Test(priority = 3)
    public void testCreateGroupEmpty() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("", "", "");
        submitGroupCreation();
        returnToGroupPage();
        System.out.println("testCreateGroupEmpty() passed");
    }
}
