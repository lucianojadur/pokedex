package strategy;

import pokedex.Pokedex;

public class RemoveTypeStrategy extends TypeStrategy{

	public RemoveTypeStrategy(){}

	public boolean executeQuery(String name, Pokedex pokedex){
		return pokedex.removeTypeFrom(name, askType());
	}
}