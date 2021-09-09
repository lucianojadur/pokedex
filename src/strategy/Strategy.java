package strategy;

import ui.EscapeSequences;
import pokedex.Pokedex;

public interface Strategy extends EscapeSequences{

	public abstract boolean executeQuery(String name, Pokedex pokedex);

}









