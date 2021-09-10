public abstract class Hierarchy {
	//
	//Abstract declaration of a pokemon output.
	//It depends on which kind of hierarchy the pokemon is referred to
	//(itself or an evolution of another one)
	public abstract void showDataOf(Pokemon p);

	//
	//Output for any pokemon's intrinsic features
	protected void printTypes(Pokemon p){
		System.out.print("Type(s): | ");
		for(Type t : p.types())
			System.out.print(t.name() + " | ");
		System.out.println();
	}
}