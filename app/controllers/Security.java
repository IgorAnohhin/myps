package controllers;

import models.*;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 30.09.12
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
public class Security extends Secure.Security {

    static boolean authenticate(String email, String password) {
        return Author.connect(email, password) != null;
    }

    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return Author.find("byEmail", connected()).<Author>first().getIsAdmin();
        }
        return false;
    }

    static void onDisconnected(){
        Application.index();
    }

    static void onAuthenticated() {
        Admin.index();
    }
}