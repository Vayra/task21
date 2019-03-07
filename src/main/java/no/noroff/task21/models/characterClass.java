package no.noroff.task21.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "characterClass")
public class characterClass {

    public characterClass() {}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    @Column(name = "className")
    private String className;

    @Id
    @Column(name = "classID")
    private int classID;

    @Column(name = "description")
    private String description;

    @Column(name = "abilities")
    private String abilities;
}
