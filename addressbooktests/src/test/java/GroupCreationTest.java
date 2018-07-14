import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation()  {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm("StudyHome", "header", "footer");
        submitGroupCreation();
        returnToGroupPage();
    }

}
