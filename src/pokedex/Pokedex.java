package pokedex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import pokemon.Pokemon;
import types.Type;
import hierarchy.*;
import iofiles.FileUpdater;


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


	public static Pokedex getInstance(HashMap<String,Pokemon> data, String source){
		if (Pokedex.singleton == null)
			singleton = new Pokedex(data, source);
		
		return singleton;
	}
	

	public Integer amountOfPokemons(){
		return pokemons.size();
	}


	public Pokemon get(String name){
		try{
			return pokemons.get(name);
		}catch(NullPointerException e){
			return null;
		}
	}


	public void upLevelTo(String name, Integer up){
		try{
			pokemons.get(name).levelUp(up);
		}catch(NullPointerException e){
			System.out.println("That pokemon is not registered in the database.");
		}
	}

	public boolean add(String name, Integer[] levels, String type){
		if (!pokemons.containsKey(name)){
			Pokemon p = new Pokemon(name, levels, Type.valueOf(type));
			pokemons.putIfAbsent(name, p);

			FileUpdater log = new FileUpdater(user, pokemons.values());
			if(log.update())
				System.out.println("Database file updated!");
			return true;
		}
		return false;
	}


	public boolean addTypeTo(String name, String t){
		try{
			pokemons.get(name.toLowerCase()).addType(Type.valueOf(t));
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public boolean removeTypeFrom(String name, String t){
		try{
			pokemons.get(name.toLowerCase()).removeType(Type.valueOf(t));
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public boolean editNameOf(String name, String newName){
		try{
			return flipKeys(name, newName);
		}catch(NullPointerException e){
			return false;
		}
	}

		private boolean flipKeys(String oldName, String newName){
			if (pokemons.containsKey(newName))
				return false;
			pokemons.get(oldName).changeName(newName);
			pokemons.putIfAbsent(newName, pokemons.get(oldName));
			pokemons.remove(oldName);
			return true;
		}



	public boolean addEvolutionTo(String name, String ev){
		try{
			if(pokemons.get(ev) != null)
				pokemons.get(name).addEvolution(ev);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


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



	public HashSet<String> getAbilitiesOf(String pokemonName){
		try{
			Pokemon p = pokemons.get(pokemonName.toLowerCase());
			return p.abilities();
		}
		catch (NullPointerException e){
			return null;
		}
	}


	public ArrayList<String> getEvolutionsOf(String pokemonName){
		try{
			Pokemon p = pokemons.get(pokemonName.toLowerCase());
			return p.evolutions();
		}catch(NullPointerException e){
			return null;
		}
	}


	public void showPokemons(){
		instance = new Actual();
		for(Pokemon p : pokemons.values())
			instance.showDataOf(p);
	}

	public String user(){
		return user;
	}


	public String[] names(){
		return pokemons.keySet().toArray(new String[pokemons.size()]);
	}

	public String[] sortedNames(){
		String[] names = this.names();
		Arrays.sort(names);
		return names;
	}


	public boolean contains(String pokemonName){
		return pokemons.containsKey(pokemonName);
	}

	public Collection<Pokemon> getPokemons(){
		return pokemons.values();
	}
}
