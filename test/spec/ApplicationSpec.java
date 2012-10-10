package spec;

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
        assertElement(By.className("team-text"), visible);
        assertElement(By.className("team-text"), hasText("A little about myself"));
        $(".about").shouldBe(visible);
    }

    @Test
    public void checkCanNotSendContactFormWrongCaptcha(){
        open("/contact");

        assertElement(By.id("contact"), visible);

        setValue(By.id("sender_name"), "Igor Anohhin");
        setValue(By.id("sender_email"), "i.anohhin@gmail.com");
        setValue(By.id("sender_subject"), "Subject");
        setValue(By.id("cf_message"), "Message Message Message");
        click(By.className("button"));

        waitUntil(By.className("error"), visible);
        assertElement(By.className("error"), hasText("Invalid code. Please type it again!"));
    }

    @Test
    public void checkCanNotSendContactFormFieldsEmpty(){
        open("/contact");

        assertElement(By.id("contact"), visible);
        click(By.className("button"));

        waitUntil(By.className("error"), visible);
        assertElement(By.className("error"), haveText("Name is required!"));
        assertElement(By.className("error"), haveText("Email is required!"));
        assertElement(By.className("error"), haveText("Subject is required!"));
        assertElement(By.className("error"), haveText("Content is required!"));
        assertElement(By.className("error"), haveText("Invalid code. Please type it again!"));
    }
}
