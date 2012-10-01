package models;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import play.data.validation.*;
import play.libs.Mail;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 24.09.12
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class ContactForm {

    @Required(message = "Name is required!")
    private String name;

    @Email
    @Required(message = "Email is required!")
    private String email;

    @Required(message = "Subject is required!")
    private String subject;

    @Required(message = "Content is required!")
    private String content;

    public ContactForm(String name, String email, String subject, String content){
        this.setName(name);
        this.setEmail(email);
        this.setSubject(subject);
        this.setContent(content);
    }

    public void send() throws EmailException{
        String sep = (String)java.security.AccessController.doPrivileged(
            new sun.security.action.GetPropertyAction("line.separator"));

        SimpleEmail eemail = new SimpleEmail();
        eemail.setFrom("i.anohhin@gmail.com");
        eemail.addTo("i.anohhin@gmail.com");
        eemail.setSubject(this.getSubject());
        eemail.setMsg("This email (1) from: " + this.getName() + sep + this.getEmail() + sep + sep + this.getContent());
        Mail.send(eemail);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}