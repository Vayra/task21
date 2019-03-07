package no.noroff.task21.controllers;

import no.noroff.task21.models.CharacterClass;
import no.noroff.task21.models.characters;
import no.noroff.task21.models.users;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

import static no.noroff.task21.Task21Application.*;


@RestController
public class rpgController {

    @GetMapping("/users/")
    public List<users> fetchUsers(){
        return getUsers();
    }

    @GetMapping("/users/{id}")
    public users fetchUser(@PathVariable String id){
        return getUser(id);
    }

    @GetMapping("/character/{id}")
    public characters fetchCharacter(@PathVariable String id){
        return getCharacter(id);
    }

    @GetMapping("/character/id/{id}")
    public List<characters> fetchCharacterByID(@PathVariable String id){
        return getCharactersByID(id);
    }

    @GetMapping("/class/{className}")
    public CharacterClass getCharClass(@PathVariable String className){
        return getCharacterClass(className);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody users newUser){

        addUser(newUser);
    }

    @PostMapping("/character")
    public void createCharacter(@RequestBody Map<String, String> newChar){
        System.out.println("New Character");

        for(String key:newChar.keySet()){
            System.out.println(key + " : " + newChar.get(key));
        }

        addCharacter(newChar);
    }

}
