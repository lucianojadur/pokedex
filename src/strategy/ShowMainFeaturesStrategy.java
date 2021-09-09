package strategy;

import pokedex.Pokedex;
import java.util.Scanner;
import java.util.HashSet;
import output.ErrorMessages;

public class ShowMainFeaturesStrategy implements Strategy, ErrorMessages{
	
	public ShowMainFeaturesStrategy(){}


	public boolean executeQuery(String name, Pokedex pokedex){
		try{
			HashSet<String> abilities = pokedex.getAbilitiesOf(name);
		
			System.out.println("\n" + name + "'s abilities:  ");
			print(abilities);
		}catch(NullPointerException e ){
			printMsgError();
		}
		pokedex.showEvolutionsOf(name);

		return true;
	}

	private static void print(HashSet<String> set){
		if (set.size() > 0){
			for (String string : set)
				System.out.print(string + " ");
			System.out.println();
		}
		else
			System.out.println(" None...");			
	}

	public void printMsgError(){
		System.out.println(_RED_ + MISSING_KEY + _RESET_);
	}

}
