package pokedex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import pokemon.Pokemon;
import types.Type;
import hierarchy.Hierarchy;
import hierarchy.Evolution;
import hierarchy.Actual;


public class Pokedex{
	
	public static Pokedex singleton;
	private String dataSource;
	private Hierarchy instance;
	private HashMap<String,Pokemon> pokemons;

	private Pokedex(HashMap<String,Pokemon> data, String source){
		pokemons = data;
		dataSource = source;
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


	public void add(Pokemon p){
		pokemons.putIfAbsent(p.name().toLowerCase(), p);
	}


	public boolean addTypeTo(String name, Type t){
		try{
			pokemons.get(name.toLowerCase()).addType(t);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public boolean removeTypeFrom(String name, Type t){
		try{
			pokemons.get(name.toLowerCase()).removeType(t);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public boolean editNameOf(String name, String newName){
		try{
			pokemons.get(name).changeName(newName);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public boolean addEvolutionTo(String name, String ev, Integer[] evLevels){
		try{
			pokemons.get(name).addEvolution(ev);
			if (!pokemons.containsKey(name)){
				Pokemon p = new Pokemon(ev, evLevels);
				pokemons.putIfAbsent(ev, p);
			}
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public void showAbilitiesOf(String pokemonName){
		try{
			System.out.println(pokemonName + "'s abilities:  ");
			HashSet<String> abilities = pokemons.get(pokemonName.toLowerCase()).abilities();
			for (String ability : abilities)
				System.out.print(ability + " ");
			System.out.println();
		}
		catch (NullPointerException e){
			System.out.println(pokemonName + " is not registered on the database.");
		}
	}


	public void showEvolutionsOf(String pokemonName){
		try{
			instance = new Evolution();
			System.out.println(pokemonName + "'s evolutions: \n");
			ArrayList<String> evolutions = pokemons.get(pokemonName.toLowerCase()).evolutions();

			try{
				for (String name : evolutions)
				instance.showDataOf(pokemons.get(name.toLowerCase()));
			}catch(NullPointerException e){
				System.out.println(pokemonName + " has not registered evolutions.");
			}
		}
		catch (NullPointerException e){
			System.out.println(pokemonName + " is not registered on the database.");
		}
	}


	public void showPokemons(){
		instance = new Actual();
		for(Pokemon p : pokemons.values())
			instance.showDataOf(p);
	}


	public Set<String> pokemons(){
		return pokemons.keySet();
	}

}
