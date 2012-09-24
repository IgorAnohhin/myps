import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup(){
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrievUserTest() {
        new User("igor@post.ee", "Igor", "pass").save();
        User igor = User.find("byFullName", "Igor").first();
        assertNull(igor);
    }

}
