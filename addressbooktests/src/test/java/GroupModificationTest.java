import org.junit.Test;

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
