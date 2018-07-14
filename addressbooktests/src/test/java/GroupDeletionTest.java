
import org.junit.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion(){

        goToGroupPage();
        selectFirstGroup();
        deleteGroup();
        returnToGroupPage();
    }




}
