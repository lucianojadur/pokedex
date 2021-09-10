package strategy;

import pokedex.Pokedex;
import java.util.Scanner;
import output.ErrorMessages;

public class ShowDataStrategy implements Strategy, ErrorMessages{
	
	public ShowDataStrategy(){}


	public boolean executeQuery(String name, Pokedex pokedex){
		if (!pokedex.showDataOf(name.toLowerCase()))
			printMsgError();
		return true;
	}

	public void printMsgError(){
		System.out.println(_RED_ + MISSING_KEY + _RESET_);
	}
}