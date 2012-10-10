import org.junit.*;
import play.Play;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @Test
    public void testWorksPage(){
        Response response = GET("/works");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(Play.defaultWebEncoding, response);
    }

    @Test
    public void testSkillsPage(){
        Response response = GET("/skills");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(Play.defaultWebEncoding, response);
    }

    @Test
    public void testInterestsPage(){
        Response response = GET("/interests");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(Play.defaultWebEncoding, response);
    }

    @Test
    public void testContactPage(){
        Response response = GET("/contact");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(Play.defaultWebEncoding, response);
    }

    @Test
    public void testContactPostPage(){
        Response response = POST("/contact");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(Play.defaultWebEncoding, response);
    }

    @Test
    public void testAdminSecurity() {
        Response response = GET("/admin");
        assertStatus(302, response);
        assertHeaderEquals("Location", "/secure/login", response);
    }
    
}