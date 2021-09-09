package strategy;

import pokedex.Pokedex;

public class AddTypeStrategy extends TypeStrategy {

	public AddTypeStrategy(){}

	public boolean executeQuery(String name, Pokedex pokedex){
		return pokedex.addTypeTo(name, askType());
	}
}