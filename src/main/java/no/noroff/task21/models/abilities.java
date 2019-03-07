package no.noroff.task21.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abilities")
public class abilities {

    public abilities() {}

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Column(name = "classID")
    private int classID;

    @Column(name = "ability")
    private String ability;

    @Id
    @Column(name = "abilityID")
    private int abilityID;
}
