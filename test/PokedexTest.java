import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.ArrayList;

public class PokedexTest{

	String[] names = new String[]{"Bulbasaur", "Charmander", "Squirtle"};

	@Test
	public void Test01AllPokemonsAreRegisteredOnTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		String[] registeredNames = p.sortedNames();
		
		assertArrayEquals(names, registeredNames);
	}


	@Test
	public void Test02ICanNotAddARepeatedPokemonToTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		Integer expectedAmount = 3;
		Integer[] levels = new Integer[] {10,1};
		p.add("Squirtle",levels,"WATER");
		
		assertEquals(expectedAmount, p.amountOfPokemons());
	}


	@Test
	public void Test03IfAPokemonIsNotInTheDatabaseThenICanNotGetItIfILookForIt(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		assertNull(p.get("pikachu"));
	}

	@Test
	public void Test04GivenASpecificPokemonNameItsNameIsRetrievedFromTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		assertEquals("Squirtle",p.get("squirtle").name());
	}

	@Test
	public void Test05GivenASpecificPokemonNameItsTypeIsRetrievedFromTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		HashSet<Type> types = p.get("squirtle").types();
		Type[] arrayTypes = types.toArray(new Type[types.size()]);

		assertEquals(Type.valueOf("WATER"),arrayTypes[0]);
	}
	

	@Test
	public void Test06GivenASpecificPokemonNameItsLevelWhenWasFoundIsRetrievedFromTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());
		//
		//According to the input data file
		assertEquals(1, p.get("bulbasaur").levelWhenFound());
	}


	@Test
	public void Test07GivenASpecificPokemonNameItsAbilitiesAreRetrievedFromTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());
		//
		//According to the input data file
		for (String ability : p.getAbilitiesOf("bulbasaur"))
			assertEquals("overgrow", ability.toLowerCase());
	}


	@Test
	public void Test08GivenASpecificPokemonNameItsEvolutionsAreRetrievedFromTheDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());
		//
		//According to the input data file
		ArrayList<String> evolutionsRetrieved = p.getEvolutionsOf("charmander");
		
		assertEquals("charmeleon", evolutionsRetrieved.get(0).toLowerCase());
		assertEquals("charizard", evolutionsRetrieved.get(1).toLowerCase());
	}

	@Test
	public void Test09IfAddANewPokemonToThePokedexItRemainsSavedOnItsDatabase(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		Integer[] levels = new Integer[] {60,55};
		p.add("Dragonite", levels, "DRAGON");

		Integer expectedLv = 60;
		assertEquals("Dragonite", p.get("dragonite").name());
		assertEquals(expectedLv, p.get("dragonite").levelWhenFound());
	}


	@Test
	public void Test10APokemonInformationCanBeUpdated(){
		Parser parser = Parser.getDataFrom("test_file.csv");
		Pokedex p = Pokedex.getInstance(parser.getDB(), parser.userName());

		Integer lv = p.get("bulbasaur").level();
		p.upLevelTo("bulbasaur", 5);
		assertEquals(lv+5, p.get("bulbasaur").level());

		p.editNameOf("Squirtle", "Squeral");
		assertFalse(p.contains("squirtle"));
		assertTrue(p.contains("squeral"));
		//
		//Restarting original setup.
		p.editNameOf("squeral", "Squirtle");
	}

}
