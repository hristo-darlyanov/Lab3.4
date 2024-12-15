package characters;
import abstracts.Job;
import java.util.Objects;

public class Citizen{
    public Job job;
    public String name;

    public Citizen(String name) {
        this.name = name;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(name, citizen.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
