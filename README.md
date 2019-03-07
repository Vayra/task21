# task21

# GET Options

**/users/**     --Gets all users  

**/user/{id}**  -- Gets user by ID number

**/character/{name}** -- Gets character by character name

**/character/id/{id}** -- Gets all characters tied to the user ID.

**/class/{className}** -- Gets class by name

# POST Options

**/user** -- Adds user to the DB  
Example format:
curl -i -H "Content-Type: application/json" -X POST -d '{  
"username" : "user1",  
"password" : "pass",  
"email"    : "user@gmail.com"  
}' localhost:8080/user

**/character** -- Adds character to the DB  
Example format:  
curl -i -H "Content-Type: application/json" -X POST -d '{  
"userID"         : 1,  
"characterName"  : "Bob",  
"level"          : 50,  
"characterClass" : "Blackguard"  
}' localhost:8080/character
