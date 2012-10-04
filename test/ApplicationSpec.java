//import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import play.test.UnitTest;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DOM.*;
import static com.codeborne.selenide.Navigation.baseUrl;
import static com.codeborne.selenide.Navigation.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 2.10.12
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationSpec {
    //@Rule
    //public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

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
