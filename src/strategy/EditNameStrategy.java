package strategy;

import pokedex.Pokedex;
import java.util.Scanner;

public class EditNameStrategy implements Strategy{

	public EditNameStrategy(){}

	public boolean executeQuery(String name, Pokedex pokedex){
		return pokedex.editNameOf(name, askNewName());
	}

	private static String askNewName(){
		System.out.print(_CYAN_ + "Enter your pokemon's new name: " + _RESET_);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
