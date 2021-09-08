//package pokemon;
import pokemon.Pokemon;
import pokedex.Pokedex;
import types.Type;
import parser.Parser;

public class main{
	public static void main(String[] argv){

		Parser parser = Parser.getDataFrom(argv[0]);
		Pokemon pikachu = new Pokemon("Pikachu", 4, Type.ELECTRIC);

		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());
		
		
		System.out.println("\nAdding to the database...\n");

		p.add(pikachu);
//		p.add(bulbasaur);
		p.showPokemons();

//		if(!p.addTypeTo(bulbasaur.name(), Type.POISON))
//			System.out.println("Error");
		p.showPokemons();
		for(Pokemon pok : p.getDB().values()){
			pok.showAbilities();
			pok.showEvolutions();
		}
	}
}
