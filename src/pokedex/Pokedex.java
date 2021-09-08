package pokedex;

import java.util.HashMap;
import pokemon.Pokemon;
import types.Type;



public class Pokedex{
	
	public static Pokedex singleton;
	private String dataSource;
	private HashMap<String,Pokemon> pokemons;

	private Pokedex(HashMap<String,Pokemon> data, String source){
		pokemons = data;
		dataSource = source;
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


	public boolean addEvolutionTo(String name, String ev, Integer evLevel){
		try{
			pokemons.get(name).addEvolution(ev);
			if (!pokemons.containsKey(name)){
				Pokemon p = new Pokemon(ev, evLevel);
				pokemons.putIfAbsent(ev, p);
			}
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public void showAbilitiesOf(String pokemonName){
		try{
			pokemons.get(pokemonName.toLowerCase()).showAbilities();
		}catch (NullPointerException e){
			System.out.println("The searched pokemon is not registered on the database.");
		}
	}


	public void showEvolutionsOf(String pokemonName){
		try{
			pokemons.get(pokemonName.toLowerCase()).showEvolutions();
		}catch (NullPointerException e){
			System.out.println("The searched pokemon is not registered on the database.");
		}
	}


	public void showPokemons(){
		for(Pokemon p : pokemons.values())
			p.showData();
	}

	public HashMap<String,Pokemon> getDB(){
		return pokemons;
	}

}
