package courseplus_ziyi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
public class Course {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @OneToMany(mappedBy="course", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Module> modules;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        //DateTime date = new DateTime(created);
        this.created = created;
    }
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
    public List<Module> getModules() {
        return modules;
    }
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}