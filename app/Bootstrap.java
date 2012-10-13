import play.jobs.*;
import play.test.*;

import models.*;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 23.09.12
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        if(Author.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}
