package entity;
import javax.persistence.Entity;
@Entity
public class EmpDetails {
    private String name;
    private String job;
    public EmpDetails(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public EmpDetails() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
}