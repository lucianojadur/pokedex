package pokedex;

import java.util.HashMap;
import pokemon.Pokemon;
import types.Type;



public class Pokedex{
	
	public static Pokedex singleton;
	private HashMap<String,Pokemon> pokemons;


	private Pokedex(){
		pokemons = new HashMap<String,Pokemon>();
	}

	public static Pokedex getInstance(){
		if (Pokedex.singleton == null)
			singleton = new Pokedex();
		
		return singleton;
	}
	
	public Integer amountOfPokemons(){
		return pokemons.size();
	}

	public void add(Pokemon p){
		pokemons.putIfAbsent(p.name().toLowerCase().toLowerCase(), p);
	}

	public boolean addTypeTo(String name, Type t){
		try{
			pokemons.get(name.toLowerCase()).addType(t);
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

	public boolean addEvolutionTo(String name, Pokemon ev){
		try{
			pokemons.get(name).addEvolution(ev);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public void showPokemons(){
		for(Pokemon p : pokemons.values())
			p.showData();
	}
}
