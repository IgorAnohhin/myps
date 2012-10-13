package controllers;

import play.mvc.*;

import models.*;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 30.09.12
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)
public class Admin extends Controller {

    @Before
    static void setConnectedUser(){
        if(Security.isConnected()){
            Author author = Author.find("byEmail", Security.connected()).first();
            renderArgs.put("user", author.getFullName());
        }
    }

    public static void index(){
        render();
    }
}
