package hierarchy;

import pokemon.Pokemon;


public class Evolution extends Hierarchy {

	public void showDataOf(Pokemon p){
		System.out.println("Name: " + p.name());
		printTypes(p);
		System.out.println("Min. level to reach: " + p.minLv() + "\n");
	}
}