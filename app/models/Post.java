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

    private Boolean isFront;

    @ManyToOne
    @Required(message = "User is required")
    private User author;

    public Post(User author, String title, String content, Date postedDate, Boolean isFront){
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(content);
        this.setPostedDate(postedDate);
        this.setIsFront(isFront);
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Boolean getIsFront() {
        return isFront;
    }

    public void setIsFront(Boolean front) {
        isFront = front;
    }

    public String toString(){
        return this.getTitle();
    }
}