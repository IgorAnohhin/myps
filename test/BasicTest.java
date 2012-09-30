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
        new User("igor@post.ee", "Igor", "pass", true).save();
        User igor = User.find("byFullName", "Igor").first();
        assertNotNull(igor);
        assertEquals("Igor", igor.getFullName());
        assertEquals("igor@post.ee", igor.getEmail());

        assertNotNull(User.connect("Igor", "pass"));
        assertEquals("Igor", User.connect("Igor", "pass").getFullName());
        assertEquals("igor@post.ee", User.connect("Igor", "pass").getEmail());
    }

    @Test
    public void addPostToUserTest(){
        User igor = new User("igor@post.ee", "Igor", "pass", true).save();
        assertEquals(igor.getPosts().size(), 0);

        igor.addPost("Post Title", "Post Content", new Date(), true);
        assertEquals(igor.getPosts().size(), 1);

        assertEquals("Igor", igor.getPosts().get(0).getAuthor().getFullName());
        //Post postOne = new Post(igor, "Post Title", "Post Content").save();
    }

    @Test
    public void createAndRetrievPostTest(){
        User igor = new User("igor@post.ee", "Igor", "pass", true).save();

        new Post(igor, "Post Title", "Post Content", new Date(), true).save();
        Post post = Post.find("byTitle", "Post Title").first();
        assertNotNull(post);
        post.setIsFront(true);
        assertTrue(post.getIsFront());
    }

    @Test
    public void createAndRetrievContactForm(){
        ContactForm contact = new ContactForm("Ella", "ella@post.ee", "Subject", "Message Content");
        assertNotNull(contact);
        assertEquals("Message Content", contact.getContent());
    }

}