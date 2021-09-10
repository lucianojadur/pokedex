
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
//import Pokemon;
//import Type;
//ipmort Parser;



public class Pokedex{
	
	public static Pokedex singleton;
	private String user;
	private Hierarchy instance;
	private HashMap<String,Pokemon> pokemons;

	private Pokedex(HashMap<String,Pokemon> data, String source){
		pokemons = data;
		user = source;
		instance = null;
	}

	//
	//As it might exist just one Pokedex at a time, it just creates
	//only one instance of Pokedex and is  used by the same user until
	//the program stops or ends.
	public static Pokedex getInstance(HashMap<String,Pokemon> data, String source){
		if (Pokedex.singleton == null)
			singleton = new Pokedex(data, source);
		
		return singleton;
	}
	
	//
	//Returns the amount of pokemons saved in the virtual storage
	public Integer amountOfPokemons(){
		return pokemons.size();
	}

	//
	//given a pokemon's name, it returns a container with all the data of thar pokemon.
	//If a not registered pokemon or entity is entered, it returns a null reference.
	public Pokemon get(String name){
		try{
			return pokemons.get(name);
		}catch(NullPointerException e){
			return null;
		}
	}

	//
	//Given a name, a pair of integer numbers and a string with a type of nature in its name,
	//it creates, saves and writes in the source data file a new pokemon with that information.
	public boolean add(String name, Integer[] levels, String type){
		if (!pokemons.containsKey(name.toLowerCase())){
			Pokemon p = new Pokemon(name, levels, Type.valueOf(type));
			pokemons.putIfAbsent(name.toLowerCase(), p);

			FileUpdater log = new FileUpdater(user, pokemons.values());
			if(log.update())
				System.out.println("Database file updated!");
			return true;
		}
		return false;
	}

	//
	//increases the current level of a given pokemon (called by <name>)
	//in an amout of <up>
	public void upLevelTo(String name, Integer up){
		try{
			pokemons.get(name).levelUp(up);
		}catch(NullPointerException e){
			System.out.println("That pokemon is not registered in the database.");
		}
	}

	//
	//Given the name of a pokemon, it adds to him/her a new type of nature
	//given by a string with its name.
	public boolean addTypeTo(String name, String t){
		try{
			pokemons.get(name.toLowerCase()).addType(Type.valueOf(t));
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}

	//
	//Given the name of a pokemon, it removes from him/her a the type of nature
	//given by a string with its name.
	public boolean removeTypeFrom(String name, String t){
		try{
			pokemons.get(name.toLowerCase()).removeType(Type.valueOf(t));
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}

	//
	//It modifies the name of a certain pokemon. As the name works as an identifier,
	//future requests referred to that pokemon must be asked with its new name.
	public boolean editNameOf(String name, String newName){
		try{
			return flipKeys(name, newName);
		}catch(NullPointerException e){
			return false;
		}
	}
		//
		//It swaps a pokemon from its current name to its new name.
		//current name (after this, "former name") will map a reference to null.
		private boolean flipKeys(String oldName, String newName){
			if (pokemons.containsKey(newName.toLowerCase()))
				return false;
			try{
				pokemons.get(oldName.toLowerCase()).changeName(newName);
				pokemons.putIfAbsent(newName.toLowerCase(), pokemons.get(oldName.toLowerCase()));
				pokemons.remove(oldName.toLowerCase());
			} catch(NullPointerException e){
				return false;
			}
			return true;
		}


	//
	//It takes the name of two pokemons (expected to be both of them previously registered)
	//and writes the second one down as an evolution of the first one.
	public boolean addEvolutionTo(String name, String ev){
		try{
			if(pokemons.get(ev) != null)
				pokemons.get(name).addEvolution(ev);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}

	//
	//It prints in an appropiate format the basic information of a pokemon searched by its name
	public boolean showDataOf(String pokemonName){
		instance = new Actual();
		System.out.println();
		try{
			instance.showDataOf(pokemons.get(pokemonName));
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}

	//
	//It prints the abilities registered from a certain pokemon searched by its name.
	public boolean showAbilitiesOf(String pokemonName){
		try{
			Pokemon p = pokemons.get(pokemonName.toLowerCase());

			System.out.println("\n" + p.name() + "'s abilities:  ");
			for (String a : p.abilities())
				System.out.print(a + " ");
			
			System.out.println();
			return true;
		}
		catch (NullPointerException e){
			return false;
		}
	}

	//
	//It prints the evolutions registered from a certain pokemon searched by its name.
	public boolean showEvolutionsOf(String pokemonName){
		try{
			instance = new Evolution();
			Pokemon p = pokemons.get(pokemonName.toLowerCase());

			System.out.println("\n" + p.name() + "'s evolutions: \n");
			try{
				if(p.evolutions().isEmpty())
					System.out.println("It has no evolutions so far...");

				for (String name : p.evolutions())
					instance.showDataOf(pokemons.get(name.toLowerCase()));
			}catch(NullPointerException e){
				return false;
			}
		}
		catch (NullPointerException e){
			return false;
		}
		return true;
	}


	//
	//It returns a set of the strings with the names of the abilities of a pokemon searched by its name.
	public HashSet<String> getAbilitiesOf(String pokemonName){
		try{
			Pokemon p = pokemons.get(pokemonName.toLowerCase());
			return p.abilities();
		}
		catch (NullPointerException e){
			return null;
		}
	}

	//
	//It returns a set of the strings with the names of the evolutions of a pokemon searched by its name.	
	public ArrayList<String> getEvolutionsOf(String pokemonName){
		try{
			Pokemon p = pokemons.get(pokemonName.toLowerCase());
			return p.evolutions();
		}catch(NullPointerException e){
			return null;
		}
	}

	//
	//It prints the whole list of pokemons registered so far and shows, for each one, their basic informations.
	public void showPokemons(){
		instance = new Actual();
		for(Pokemon p : pokemons.values())
			instance.showDataOf(p);
	}

	//
	//It returns the user whom the current pokedex data belongs to.
	public String user(){
		return user;
	}

	//
	//It returns an array of the names of the pokemons storaged.
	public String[] names(){
		String[] names = new String[pokemons.size()];
		Pokemon[] pok = pokemons.values().toArray(new Pokemon[pokemons.size()]);
		for (int i = 0; i < pokemons.size(); i++){
			try {names[i] =  pok[i].name();}
			catch(NullPointerException e) {names[i] = " ";};
		}
		return names;
	}

	public String[] sortedNames(){
		String[] names = this.names();
		Arrays.sort(names);
		return names;
	}

	//
	//Given a string with the name of a pokemon, it returns true if the pokemon is registered on the database
	//and it returns false otherwise. 
	public boolean contains(String pokemonName){
		return pokemons.containsKey(pokemonName.toLowerCase());
	}

	public Collection<Pokemon> getPokemons(){
		return pokemons.values();
	}
}
