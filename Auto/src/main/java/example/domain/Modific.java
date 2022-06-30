package example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name ="Modific")
public class Modific {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String name;
    @Column
    private boolean active;
    @Column
    private int beginPeriod;
    @Column
    private int endPeriod;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    public Modific(String name, boolean active, int beginPeriod, int endPeriod) {
        this.name = name;
        this.active = active;
        this.beginPeriod = beginPeriod;
        this.endPeriod = endPeriod;
    }

    public Modific() {

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

    public int getBeginPeriod() {
        return beginPeriod;
    }

    public void setBeginPeriod(int beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

