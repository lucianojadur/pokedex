import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import types.Type;
import pokemon.Pokemon;
import parser.Parser;

public class PokedexTest{

	String[] names = new String[]{"bulbasaur", "charmander", "squirtle"};

	Parser parser = Parser.getDataFrom("test_file.csv");
	Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());


	@Test
	public void AllPokemonsAreRegisteredOnTheDatabase(){
		String[] registeredNames = p.sortedNames();
		assertEquals(names,registeredNames);
	}

	@Test
	public void ICanNotAddARepeatedPokemonToTheDatabase(){
		int[] levels = new int[] {10,1};
		p.add("Squirtle",levels,WATER);
		asertEquals(p.amountOfPokemons(), 3);
	}

	@Test
	public void IfAPokemonIsNotInTheDatabaseThenICanNotGetItIfILookForIt(){
		asertEquals(false, p.get("pikachu"));
	}

	@Test
	public void GivenASpecificPokemonNameItsNameIsRetrievedFromTheDatabase(){
		asertEquals(p.get("squirtle").name().toLowerCase(), "squirtle");
	}

	@Test
	public void GivenASpecificPokemonNameItsTypeIsRetrievedFromTheDatabase(){
		asertEquals(p.get("squirtle").type().valueOf(), Type.valueOf("WATER"));
	}
	

	@Test
	public void GivenASpecificPokemonNameItsLevelWhenWasFoundIsRetrievedFromTheDatabase(){
		//
		//According to the input data file
		assertEquals(p.get("bulbasaur").levelWhenFound(), 1);
	}


	@Test
	public void GivenASpecificPokemonNameItsAbilitiesAreRetrievedFromTheDatabase(){
		//
		//According to the input data file
		for (String ability : p.getAbilitiesOf("bulbasaur"))
			assertEquals(ability.toLowerCase(), "overgrow");
	}


	@Test
	public void GivenASpecificPokemonNameItsEvolutionsAreRetrievedFromTheDatabase(){
		//
		//According to the input data file
		ArrayList<String> evolutions = new ArrayList<String>();
		evolutions.add("charmeleon");
		evolutions.add("charizard");
		ArrayList<String> evolutionsRetrieved = p.getEvolutionsOf("charmander");

		for (int i = 0; i < 2; i++)
			assertEquals(evolutionsRetrieved.get(i).toLowerCase(), evolutions.get(i));
	}

	@Test
	public void IfAddANewPokemonToThePokedexItRemainsSavedOnItsDatabase(){
		int[] levels = new int[] {60,55};
		p.add("Dragonite", levels, Type.valueOf("DRAGON"));

		assertEquals(p.get("dragonite").name().toLowerCase(), "dragonite");
		assertEquals(p.get("dragonite").levelWhenFound(), 60);
	}


	@Test
	public void APokemonInformationCanBeUpdated(){
		Integer lv = p.get(bulbasaur).level();
		p.upLevelTo("bulbasaur", 5);
		assertEquals(p.get(bulbasaur).level(), lv+5);

		p.editNameOf("squirtle", "squeral");
		p.assertEquals(p.contains("squirtle"), false);
		p.assertEquals(p.contains("squeral"), true);
	}

}
