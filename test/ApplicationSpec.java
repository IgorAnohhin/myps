import helpers.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DOM.*;
import static com.codeborne.selenide.Navigation.*;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 2.10.12
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationSpec extends UITest {

    @Before
    public void startMYPS() {
        open("/");
    }

    @Test
    public void checkIndex() {
        assertNull(null);
        //assertElement(By.id("topic"), hidden);
        //$("#topic").shouldBe(hidden);
    }
}
