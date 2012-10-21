package controllers;

import org.apache.commons.mail.EmailException;
import play.*;
import play.cache.Cache;
import play.data.validation.*;
import play.libs.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    @Before
    public static void addDefaults() {
        renderArgs.put("blogTitle", Play.configuration.getProperty("blog.title"));
        renderArgs.put("blogBaseline", Play.configuration.getProperty("blog.baseline"));
    }

    public static void index() {
        Post post = Post.find("byMenu", Menu.FRONT).first();
        render(post);
    }

    public static void myWorks(){
        List<Post> posts = Post.find("menu = ? order by sequence asc", Menu.WORKS).fetch();
        renderTemplate("Application/myworks.html", posts);
    }

    public static void skills(){
        Post post = Post.find("byMenu", Menu.SKILLS).first();
        render(post);
    }

    public static void myInterests(){
        Post post = Post.find("byMenu", Menu.INTERESTS).first();
        renderTemplate("Application/myinterests.html", post);
    }

    public static void contact(){
        String randomID = Codec.UUID();
        render(randomID);
    }

    public static void saveContact (
            @Required(message = "Name is required!") String name,
            @Required(message = "Email is required!") String email,
            @Required(message = "Subject is required!") String subject,
            @Required(message = "Content is required!") String content,
            String code,
            String randomID){

        validation.equals(
                code, Cache.get(randomID)
        ).message("Invalid code. Please type it again!");

        if (validation.hasErrors()) {
            render("Application/contact.html", randomID);
        }

        ContactForm contact = new ContactForm(name, email, subject, content);
        try {
            contact.send();
        } catch (EmailException em){
            System.out.println("ERROR:> " + em.getMessage());
            render("Application/contact.html", randomID);
        }

        flash.success("Thank you for message %s!", name);
        Cache.delete(randomID);
        contact();
    }

    public static void captcha(String id) {
        Images.Captcha captcha = Images.captcha();
        String code = captcha.getText("#E4EAFD");
        Cache.set(id, code, "10mn");
        renderBinary(captcha);
    }

}