package strategy;

import pokedex.Pokedex;
import java.util.Scanner;

public abstract class TypeStrategy implements Strategy{
	
	//
	//
	public abstract boolean executeQuery(String name, Pokedex pokedex);

	//
	//Asks the user for a valid string which represents a type of nature
	protected static String askType(){
		System.out.print(_CYAN_ + "Insert a type of nature: " + _RESET_);		
		Scanner scanner = new Scanner(System.in);
		try{
			return scanner.nextLine().toUpperCase();
		}catch(Exception e){
			return null;
		}
	}

}