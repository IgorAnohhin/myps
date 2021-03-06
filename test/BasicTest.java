import models.Menu;
import org.junit.*;

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
        new Author("igor@post.ee", "Igor", "balik", true).save();
        Author igor = Author.find("byEmail", "igor@post.ee").first();
        assertNotNull(igor);
        igor = Author.connect("igor@post.ee", "balik");
        assertNotNull(igor);
        assertEquals("Igor", igor.getFullName());
        assertEquals("igor@post.ee", igor.getEmail());

        assertNotNull(Author.connect("igor@post.ee", "balik"));
        assertEquals("Igor", Author.connect("igor@post.ee", "balik").getFullName());
        assertEquals("igor@post.ee", Author.connect("igor@post.ee", "balik").getEmail());
    }

    @Test
    public void addPostToUserTest(){
        Author igor = new Author("igor@post.ee", "Igor", "balik", true).save();
        assertEquals(igor.getPosts().size(), 0);

        igor.addPost("Post Title", "Post Content", new Date(), Menu.FRONT, 1L);
        assertEquals(igor.getPosts().size(), 1);

        assertEquals("Igor", igor.getPosts().get(0).getAuthor().getFullName());
    }

    @Test
    public void createAndRetrievPostTest(){
        Author igor = new Author("igor@post.ee", "Igor", "balik", true).save();

        new Post(igor, "Post Title", "Post Content", new Date(), Menu.FRONT, 2L).save();
        Post post = Post.find("byTitle", "Post Title").first();
        assertNotNull(post);
        assertEquals(Menu.FRONT, post.getMenu());
    }

    @Test
    public void getPostsCountTest(){
        Author igor = new Author("igor@post.ee", "Igor", "balik", true).save();

        Post post = new Post(igor, "Post Title", "Post Content", new Date(), Menu.WORKS, 1L).save();
        Long count = post.getPostsCount();
        assertNotNull(count);
        assertEquals((Long)1L, count);
        new Post(igor, "Post Title", "Post Content", new Date(), Menu.WORKS, 2L).save();
        count = post.getPostsCount();
        assertEquals((Long)2L, count);
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