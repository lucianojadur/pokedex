package ui;

import strategy.*;

//
//A some kind of a strategy-pattern implementation of the "edit pokemon" menu.
public interface Edition {

	public final static Strategy[] editionStrategies = new Strategy[]{
		new EditNameStrategy(),
		new AddTypeStrategy(),
		new RemoveTypeStrategy(),
		new AddEvolutionStrategy(),
		new ExitStrategy(),
	};

}