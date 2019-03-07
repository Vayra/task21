package no.noroff.task21.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class characters {

    public characters(){}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    @Override
    public String toString(){
        return characterName + ", " + characterClass + " " + level;
    }

    @Column(name="userID")
    private int userID;

    @Id
    @Column(name="characterName")
    private String characterName;

    @Column(name="level")
    private int level;

    @Column(name = "characterClass")
    private String characterClass;
}
