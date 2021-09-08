package hierarchy;

import pokemon.Pokemon;
import types.Type;

public abstract class Hierarchy {

	public abstract void showDataOf(Pokemon p);

	protected void printTypes(Pokemon p){
		System.out.print("Type(s): | ");
		for(Type t : p.types())
			System.out.print(t.name() + " | ");
		System.out.println();
	}
}