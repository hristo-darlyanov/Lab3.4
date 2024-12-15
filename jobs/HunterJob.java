package jobs;
import abstracts.Job;
import interfaces.Resource;

public class HunterJob extends Job {
    @Override
    public void performDuties(Resource resource) {
        super.performDuties(resource);
        System.out.println("Gathering food resources.");
    }
}
