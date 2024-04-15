package courseplus_ziyi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JsonIgnore
    private Module module;
    @OneToMany(mappedBy="lesson", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Topic> topics;
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
    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
    public List<Topic> getTopics() {
        return topics;
    }
    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}

