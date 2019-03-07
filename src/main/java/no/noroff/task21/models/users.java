package no.noroff.task21.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class users implements Serializable {

    public users(){} // Empty constructor for deserializer

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<characters> getChars(){
        return characters;
    }

    public void addChars(characters character){
        characters.add(character);
        character.setUser(this);
    }

    @Id
    @GeneratedValue(generator = "incrementer")
    @GenericGenerator(name = "incrementer", strategy = "increment")
    private int id;

    private String username;

    private String password;

    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<characters> characters = new ArrayList<>();

    @Override
    public String toString(){
        return username + " ****, " + email;
    }
}

