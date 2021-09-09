package strategy;

import pokedex.Pokedex;
import java.util.Scanner;
import output.ErrorMessages;

public class AddPokemonStrategy implements Strategy, ErrorMessages{
	
	public AddPokemonStrategy(){}


	public boolean executeQuery(String name, Pokedex pokedex){
		if(!registerNewPokemon(name, pokedex))
			printMsgError();
		return true;
	}

	private static boolean registerNewPokemon(String name, Pokedex pokedex){
		Integer[] lvls = askLevels();
		String type = askType();
		if(name == null || lvls == null || type == null)
			return false;
		pokedex.add(name, lvls, type);
		return true;
	}


	private static Integer[] askLevels(){
		Integer[] lvls = new Integer[2];
		Scanner scanner = new Scanner(System.in);
		
		try{
			System.out.print(_CYAN_ + "Insert current level: " + _RESET_);
			lvls[0] = Integer.parseInt(scanner.nextLine());
			System.out.print(_CYAN_ + "Insert minimum level to evolve to: " + _RESET_);		
			lvls[1] = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e){
			return null;
		}
		return lvls;
	}

	private static String askType(){
		System.out.print(_CYAN_ + "Insert a type of nature: " + _RESET_);		
		Scanner scanner = new Scanner(System.in);
		try{
			return scanner.nextLine().toUpperCase();
		}catch(Exception e){
			return null;
		}
	}

	public void printMsgError(){
		System.out.println(_RED_ + WRONG_VALUE + _RESET_);
	}
}