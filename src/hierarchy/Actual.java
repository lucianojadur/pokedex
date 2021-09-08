package hierarchy;

import pokemon.Pokemon;


public class Actual extends Hierarchy {

	public void showDataOf(Pokemon p){
		System.out.println("Name: " + p.name());
		printTypes(p);
		System.out.println("Level when found: " + p.level() + "\n");
	}
}