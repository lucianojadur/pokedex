package parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashSet;


public class ParserTest{
	
	static String source;
	static String user;
	static String[] pokemons = {
		"Bulbasaur",
		"Ivysaur",
		"Venasaur",
		"Charmander",
		"Charmeleon",
		"Charizard",
		"Squirtle",
		"Wartorlte",
		"Blastoise",
		"Caterpie",
		"Metapod",
		"Butterfree",
		"Pichu",
		"Pikachu",
		"Raichu"
	};

	final static Parser p = new Parser(ParserTest.source);


	@Test
	public void ParserReadsFirstLineOK(){
		HashSet list = new HashSet<String>();
		for (int i = 0; i < pokemons.length; i++)
			assertEquals(pokemons[i].toLowerCase(), p.getDB().setView().toLowerCase());

	}

	
	@Test
	public void AllPokemonsAreListedOnTheDbAfterParsing(String path){

	}	


}
