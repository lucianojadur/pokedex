package strategy;

import pokedex.Pokedex;
import java.util.Scanner;

public class AddEvolutionStrategy implements Strategy{

	public AddEvolutionStrategy(){}

	public boolean executeQuery(String name, Pokedex pokedex){
		return pokedex.addEvolutionTo(name, askEvName(name));
	}

	private static String askEvName(String currentName){
		System.out.print(_CYAN_ + "Enter " + currentName + "'s new evolution's name: " + _RESET_);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().toLowerCase();
	}
}