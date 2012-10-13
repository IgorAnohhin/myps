package controllers;

import models.Author;
import play.mvc.*;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 28.09.12
 * Time: 23:33
 * To change this template use File | Settings | File Templates.
 */
@CRUD.For(Author.class)
@Check("admin")
@With(Secure.class)
public class Authors extends CRUD {

}
