package characters;
import abstracts.Job;
import java.util.Objects;

public record Citizen(String name, Job job) {
    public Job getJob() {
        return this.job;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", job=" + job +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(name, citizen.name) &&
                Objects.equals(job, citizen.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job);
    }
}
