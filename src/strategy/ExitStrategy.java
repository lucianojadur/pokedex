package strategy;

import pokedex.Pokedex;
import iofiles.FileUpdater;

public class ExitStrategy implements Strategy{
	
	public ExitStrategy(){}

	public boolean executeQuery(String name, Pokedex pokedex){
		overWrite(pokedex);
		System.out.println("Apagando Pokedex...");
		return false;
	}

	private static void overWrite(Pokedex pokedex){
		FileUpdater writer = new FileUpdater(pokedex.user(), pokedex.getPokemons());
		writer.update();
	}
}