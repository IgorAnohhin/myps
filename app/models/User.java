package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.*;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 24.09.12
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model {

    @Email
    @Required(message = "Email is required!")
    private String email;

    @Required(message = "Name is required!")
    private String fullName;

    @MinSize(5)
    @Required(message = "Password is required!")
    private String password;

    private Boolean isAdmin;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;

    public User(String email, String fullName, String password, Boolean isAdmin){
        this.setPosts(new ArrayList<Post>());
        this.setEmail(email);
        this.setFullName(fullName);
        this.setPassword(password);
        this.setIsAdmin(isAdmin);
    }

    public static User connect(String email, String password){
        return find("byEmailAndPassword", email, password).first();
    }

    public void addPost(String title, String content, Date postedDate, Menu menu){
        Post post = new Post(this, title, content, postedDate, menu).save();
        this.getPosts().add(post);
        this.save();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String toString(){
        return this.getFullName();
    }
}
