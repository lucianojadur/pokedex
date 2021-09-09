package hierarchy;

import pokemon.Pokemon;


public class Actual extends Hierarchy {
	//
	//Implementation of data showing of a certain pokemon
	public void showDataOf(Pokemon p){
		System.out.println("Name: " + p.name());
		printTypes(p);
		System.out.println("Level when found: " + p.levelWhenFound() + "\n");
	}
}