package strategy;

import pokedex.Pokedex;

public class ShowListStrategy implements Strategy{
	
	public ShowListStrategy(){}


	public boolean executeQuery(String name, Pokedex pokedex){
		pokedex.showPokemons();
		return true;
	}
}