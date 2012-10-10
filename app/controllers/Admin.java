package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

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
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.getFullName());
        }
    }

    public static void index(){
        render();
    }
}
