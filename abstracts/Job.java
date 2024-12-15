package abstracts;
import interfaces.Resource;

public abstract class Job {
    public void performDuties(Resource resource){
        resource.add(1);
    }
}
