package example.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String name;
    @Column
    private boolean active;
    @Column
    private String caption;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_id")
    private Mark mark;

    @JsonManagedReference
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Modific> modifications = new ArrayList<>();

    public Model(){}

    public Model(String name, boolean active, String caption) {
        this.name = name;
        this.active = active;
        this.caption = caption;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String catrion) {
        this.caption = catrion;
    }

    public List<Modific> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modific> modifics) {
        this.modifications = modifics;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
