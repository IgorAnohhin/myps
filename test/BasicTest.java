import models.Menu;
import org.junit.*;

import java.awt.*;
import java.util.*;

import play.libs.Mail;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup(){
        Fixtures.deleteDatabase();
    }

    @Test
    public void createAndRetrievUserTest() {
        new User("igor@post.ee", "Igor", "balik", true).save();
        User igor = User.find("byEmail", "igor@post.ee").first();
        assertNotNull(igor);
        igor = User.connect("igor@post.ee", "balik");
        assertNotNull(igor);
        assertEquals("Igor", igor.getFullName());
        assertEquals("igor@post.ee", igor.getEmail());

        assertNotNull(User.connect("igor@post.ee", "balik"));
        assertEquals("Igor", User.connect("igor@post.ee", "balik").getFullName());
        assertEquals("igor@post.ee", User.connect("igor@post.ee", "balik").getEmail());
    }

    @Test
    public void addPostToUserTest(){
        User igor = new User("igor@post.ee", "Igor", "balik", true).save();
        assertEquals(igor.getPosts().size(), 0);

        igor.addPost("Post Title", "Post Content", new Date(), Menu.FRONT);
        assertEquals(igor.getPosts().size(), 1);

        assertEquals("Igor", igor.getPosts().get(0).getAuthor().getFullName());
    }

    @Test
    public void createAndRetrievPostTest(){
        User igor = new User("igor@post.ee", "Igor", "balik", true).save();

        new Post(igor, "Post Title", "Post Content", new Date(), Menu.FRONT).save();
        Post post = Post.find("byTitle", "Post Title").first();
        assertNotNull(post);
        assertEquals(Menu.FRONT, post.getMenu());
    }

    @Test
    public void createAndRetrievContactForm(){
        ContactForm contact = new ContactForm("Ella", "ella@post.ee", "Subject", "Message Content");
        assertNotNull(contact);
        assertEquals("Message Content", contact.getContent());
        try{
            contact.send();
        } catch(Exception e) {}
        String mail = Mail.Mock.getLastMessageReceivedBy("i.anohhin@gmail.com");
        assertNotNull(mail);
    }

}