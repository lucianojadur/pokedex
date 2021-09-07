//package pokemon;
import pokemon.Pokemon;
import pokedex.Pokedex;
import types.Type;

public class main{
	public static void main(String[] argv){

		Pokemon pikachu = new Pokemon("Pikachu", 4, Type.ELECTRIC);
		Pokemon bulbasaur = new Pokemon("Bulbasaur", 7, Type.PLANT);

		Pokedex p = Pokedex.getInstance();
		
		
		System.out.println("\nAdding to the database...\n");

		p.add(pikachu);
		p.add(bulbasaur);
		p.showPokemons();

		if(!p.addTypeTo(bulbasaur.name(), Type.POISON))
			System.out.println("Error");
		p.showPokemons();
	}
}
