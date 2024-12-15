package jobs;
import abstracts.Job;
import interfaces.Resource;

public class BuilderJob extends Job {
    @Override
    public void performDuties(Resource resource) {
        super.performDuties(resource);
        System.out.println("Maintaining temperature levels.");
    }
}
