package controllers;

import play.*;
import play.mvc.*;

import models.User;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 28.09.12
 * Time: 23:33
 * To change this template use File | Settings | File Templates.
 */
@CRUD.For(User.class)
@Check("admin")
@With(Secure.class)
public class Users extends CRUD {

}
