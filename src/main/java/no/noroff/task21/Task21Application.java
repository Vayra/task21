package no.noroff.task21;

import no.noroff.task21.models.characters;
import no.noroff.task21.models.characterClass;
import no.noroff.task21.models.users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class Task21Application {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("mamps");

	private static String bgDescription = "If you are called upon to fight directly for the lordly Malekith, he may deign to send you a contingent of his personal guard. " +
			"These are the Black Guard, the soldiery of our capital Naggarond, and they are the fiercest fighters in all of the Land of Chill. " +
			"Wondrously ruthless and efficient on the attack, and immovable in defense, the Black Guard are the terror of our enemies. " +
			"However, do not misuse their abilities, for they owe loyalty only to the mighty Witch King himself, and should they judge you to be at fault, you will answer to their deadly captain, Kouran. " +
			"Such unpleasantness is to be avoided if you value your life and soul." +
			"-- Furion of Clar Karond";
	private static String dokDescription = "Few are the select chosen that survive the reveries of the Death Night. " +
			"Fewer still are those who leave the Cauldron with eyes of molten brass, burning with the hatred of our Dark god. " +
			"These true chosen are taken into the cult and trained in the most secret of rites, emerging as masters of death second only to Khaine himself." +
			"-- Haridar of Har Ganeth";
	public static void main(String[] args) {

		for (users u : getUsers()){
			System.out.println(u.toString());
		}

		for (characters c : getCharacters()){
			System.out.println(c.toString());
		}

		//addClass("Blackguard", bgDescription, "'Hold the Line!', 'Cleave', 'Shield Bash'");
		addClass("Disciple of Khaine",dokDescription, "'Khaine's Embrace', 'Cleave Soul', 'Khaine's Blessing', 'Soul Infusion");

		SpringApplication.run(Task21Application.class, args);
	}

	/**
	 * Gets all users
	 * @return all users objects
	 */
	public static List<users> getUsers(){
		List<users> userList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		System.out.println("Getting users");

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			userList = manager.createQuery("SELECT s from users s", users.class).getResultList();

			transaction.commit();

		} catch (Exception e){
			if (transaction != null) transaction.rollback();
		} finally{
			manager.close();
		}

		return userList;
	}

	/**
	 * Gets a users by users ID
	 * @param id id of users
	 * @return users object, null if none found
	 */
	public static users getUser(String id){
		users u = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			u = manager.createQuery("SELECT s from users s WHERE id="+id, users.class).getSingleResult();
			transaction.commit();

		} catch (Exception e){
			if (transaction != null) transaction.rollback();
		} finally{
			manager.close();
		}

		return u;
	}

	/**
	 * Gets all characters
	 * @return a list of all characters objects
	 */
	public static List<characters> getCharacters(){
		List<characters> charList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			charList = manager.createQuery("SELECT s FROM characters s", characters.class).getResultList();

			transaction.commit();
		} catch (Exception e){
			if (transaction != null) transaction.rollback();
		} finally{
			manager.close();
		}

		return charList;
	}

	/**
	 * Get a characters by charactername
	 * @param name characters name of char to find.
	 * @return characters object found, null if none
	 */
	public static characters getCharacter(String name){
		characters c = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			c = manager.createQuery("SELECT s FROM characters s WHERE characterName='" + name +"'" , characters.class).getSingleResult();

			transaction.commit();

		} catch (Exception e){
			if (transaction != null) transaction.rollback();
		} finally{
			manager.close();
		}

		return c;
	}

	/**
	 *  Gets a list of possible characters classes
	 * @return List of characters class objects
	 */
	public static List<characterClass> getCharClasses(){
		List<characterClass> classList = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			classList = manager.createQuery("SELECT s FROM characterClass s", characterClass.class).getResultList();

			transaction.commit();
		} catch (Exception e){
			if (transaction != null) transaction.rollback();
		} finally{
			manager.close();
		}

		return classList;
	}

	/**
	 * Gets the characterClass object for the given className
	 * @param name Name of the class
	 * @return characterClass matching the name, null if none were found
	 */
	public static characterClass getCharacterClass(String name){
		characterClass c = null;

		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try{
			transaction = manager.getTransaction();
			transaction.begin();

			c = manager.createQuery("SELECT s FROM characterClass s WHERE className='" + name +"'" , characterClass.class).getSingleResult();

			transaction.commit();

		} catch (Exception e){
			if (transaction != null) transaction.rollback();
		} finally{
			manager.close();
		}

		return c;
	}

	/**
	 *  Add users to DB from arguments
	 * @param userName username of users
	 * @param password password of users
	 * @param email email of users
	 */
	public static void addUser(String userName, String password, String email){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			users newUser = new users();

			newUser.setUsername(userName);
			newUser.setPassword(password);
			newUser.setEmail(email);

			manager.persist(newUser);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		} finally {
			manager.close();
		}
	}

	/**
	 * Add users from users object. Primarily for POST messages
	 * @param u users object to add
	 */
	public static void addUser(users u){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(u);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		} finally {
			manager.close();
		}
	}


	/**
	 * Add character to given user ID
	 * @param userID user ID of user character bleongs to
	 * @param characterName Character name
	 * @param level Character level (default: 1)
	 * @param characterClass Character class
	 */
	public static void addCharacter(int userID, String characterName, int level, String characterClass){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			characters newCharacter = new characters();

			newCharacter.setUserID(userID);
			newCharacter.setCharacterName(characterName);
			newCharacter.setLevel(level);
			newCharacter.setCharacterClass(characterClass);

			manager.persist(newCharacter);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		} finally {
			manager.close();
		}
	}

	/**
	 * Add character from character object
	 * @param c character object to add
	 */
	public static void addCharacter(characters c){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			manager.persist(c);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		} finally {
			manager.close();
		}
	}

	public static void addClass(String className, String description, String abilities){
		EntityManager manager =  ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			characterClass newClass = new characterClass();

			newClass.setClassName(className);
			newClass.setDescription(description);
			newClass.setAbilities(abilities);

			manager.persist(newClass);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Failed to add class: " +e.getMessage());
			if (transaction != null) transaction.rollback();
		} finally {
			manager.close();
		}
	}

}
