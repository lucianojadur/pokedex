package strategy;

import pokedex.Pokedex;
import ui.Edition;
import ui.OptionSelector;
import output.ErrorMessages;

public class EditStrategy 
	extends OptionSelector
	implements Strategy, Edition, ErrorMessages 
{
	
	public EditStrategy(){}


	public boolean executeQuery(String name, Pokedex pokedex){
		if(!edit(name,pokedex)){
			printMsgError();
		}
		return true;
	}


	private static boolean edit(String name, Pokedex pokedex){
		if(pokedex.get(name.toLowerCase()) == null)
			return false;

		printEditionMenu();
		Integer option = askInputValue(5);

		Strategy edition = editionStrategies[option];
		return edition.executeQuery(name, pokedex);
	}



	public void printMsgError(){
		System.out.println(_RED_ + MISSING_KEY +_RESET_);
	}


	private static void printEditionMenu(){
		System.out.println("\nSelect a feature to edit:");
		System.out.println("1) Name\n2) Add type\n3) Remove type\n4) Add new evolution\n5) Return\n");
		System.out.print(_CYAN_ +"\nInput: " + _RESET_);
	}

}