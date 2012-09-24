package models;

import javax.persistence.*;

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
    private String email;
    private String fullName;
    private String password;
    private Boolean isAdmin;

    public User(String email, String fullName, String password){
        this.setEmail(email);
        this.setFullName(fullName);
        this.setPassword(password);
    }

    public static User connect(String email, String password){
        return find("byEmailAndPassword", email, password).first();
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
