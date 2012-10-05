import helpers.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DOM.*;
import static com.codeborne.selenide.DOM.assertElement;
import static com.codeborne.selenide.Navigation.*;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 5.10.12
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class AdminSpec extends UITest {

    @Before
    public void startMYPSAdminPage() {
        open("/admin");
    }

    @Test
    public void checkCantLogin(){
        $("#login").shouldBe(visible);

        setValue(By.id("username"), "Vasek");
        setValue(By.id("password"), "password");
        click(By.id("signin"));

        waitUntil(By.className("error"), visible);
        assertElement(By.className("error"), haveText("Oops, unknown username or password."));
    }
}
