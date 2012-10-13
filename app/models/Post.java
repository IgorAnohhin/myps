package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 24.09.12
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Post extends Model {

    @Required(message = "Title is required")
    private String title;

    @Lob
    @MaxSize(10000)
    @Required(message = "Content is required")
    private String content;

    private Date postedDate;

    @Required(message = "Menu is required")
    private Menu menu;

    @ManyToOne
    @Required(message = "User is required")
    private Author author;

    public Post(Author author, String title, String content, Date postedDate, Menu menu){
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(content);
        this.setPostedDate(postedDate);
        this.setMenu(menu);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }

    public Menu getMenu(){
        return menu;
    }

    public String toString(){
        return this.getTitle();
    }
}