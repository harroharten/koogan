

import models.Contact;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;


@OnApplicationStart
public class PopulateOnStart extends Job {

	public void doJob() {
        // Check if the database is empty
        if(Contact.count() == 0) {
            Fixtures.loadModels("init-data.yml");
        }
    }
}