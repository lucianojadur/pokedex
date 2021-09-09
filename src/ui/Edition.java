package ui;

import strategy.*;

public interface Edition {

	public final static Strategy[] editionStrategies = new Strategy[]{
		new EditNameStrategy(),
		new AddTypeStrategy(),
		new RemoveTypeStrategy(),
		new AddEvolutionStrategy(),
		new ExitStrategy(),
	};

}