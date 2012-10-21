package controllers;

import play.*;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.mvc.*;

import models.Post;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 27.09.12
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */

@Check("admin")
@With(Secure.class)
@CRUD.For(Post.class)
public class Posts extends CRUD{

    public static void list(int page, String search, String searchFields, String orderBy, String order) {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);

        if (page < 1) {
            page = 1;
        }

        List<Model> objects = type.findPage(page, search, searchFields, "menu, sequence", "asc", (String) request.args.get("where"));
        Long count = type.count(search, searchFields, (String) request.args.get("where"));
        Long totalCount = type.count(null, null, (String) request.args.get("where"));
        try {
            render(type, objects, count, totalCount, page, orderBy, order);
        } catch (TemplateNotFoundException e) {
            render("CRUD/list.html", type, objects, count, totalCount, page, orderBy, order);
        }
    }
}
