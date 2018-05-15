import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyGroup extends TestBase {
    @Test
    public void groupModificationTests(){
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.selectGroup();
        app.initModifyGroup();
        app.fillGroupForm(new GroupData("1", "1", "1"));
        app.submitGroupModification();
        app.returnToGroupPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after, before);
    }

}