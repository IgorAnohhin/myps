package controllers;

import play.*;
import play.mvc.*;

import models.Post;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 27.09.12
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */

@CRUD.For(Post.class)
@With(Secure.class)
public class Posts extends CRUD{

}
