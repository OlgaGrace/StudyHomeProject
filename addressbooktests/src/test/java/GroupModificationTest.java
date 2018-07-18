import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){

        goToGroupPage();
        selectFirstGroup();
        initGroupModification();
        fillGroupForm("modifName", "modifHead", "modifFoot");
        confirmGroupModification();
        returnToGroupPage();


    }


}
