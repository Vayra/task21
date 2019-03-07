# task21

# GET Options  
Returns JSON

**/users/**     --Gets all users  

**/user/{id}**  -- Gets user by ID number

**/character/{name}** -- Gets character by character name

**/character/id/{id}** -- Gets all characters tied to the user ID.

**/class/{className}** -- Gets class by name: Implemented classes: Blackguard, Disciple of Khaine, Sorceress

# POST Options
Use content type: application/json

**/user** -- Adds user to the DB  
Example format:
{  
"username" : "user1",  
"password" : "pass",  
"email"    : "user@gmail.com"  
}

**/character** -- Adds character to the DB  
Example format:  
{  
"user_id"         : 1,  
"characterName"  : "Bob",  
"level"          : 50,  
"characterClass" : "Blackguard"  
}
