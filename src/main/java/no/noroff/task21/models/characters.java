package no.noroff.task21.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class characters {

    public characters(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getLevel() {
        return level;
    }

    public void setUser(users user){
        this.user = user;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    @Override
    public String toString(){
        return characterName + ", " + characterClass.getClassName() + " " + level;
    }

    @ManyToOne
    private users user;


    @Id
    @GeneratedValue(generator = "incrementer")
    @GenericGenerator(name = "incrementer", strategy = "increment")

    private Long id;

    private String characterName;

    private int level;

    @OneToOne
    private CharacterClass characterClass;


}
