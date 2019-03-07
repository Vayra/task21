package no.noroff.task21.controllers;

import no.noroff.task21.models.characters;
import no.noroff.task21.models.characterClass;
import no.noroff.task21.models.users;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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

    @GetMapping("/class/{className}")
    public characterClass getCharClass(@PathVariable String className){
        //TODO fetch characters class by name from DB
        return getCharacterClass(className);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody users newUser){
        addUser(newUser);
    }

    @PostMapping("/character")
    public void createCharacter(@RequestBody characters newChar){
        addCharacter(newChar);
    }

}
