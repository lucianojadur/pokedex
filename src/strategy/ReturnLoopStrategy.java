package strategy;

import pokedex.Pokedex;

public class ReturnLoopStrategy implements Strategy{
	
	public ReturnLoopStrategy(){}


	public boolean executeQuery(String name, Pokedex pokedex){
		return true;
	}
}