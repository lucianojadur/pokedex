package ui;

import strategy.*;

//
//A some kind-of a strategy-pattern implementation of the main menu.
public interface MainMenu {

	public final static Strategy[] mainStrategies = new Strategy[] {
		new ShowListStrategy(),
		new ShowDataStrategy(),
		new ShowMainFeaturesStrategy(),
		new EditStrategy(),
		new AddPokemonStrategy(),
		new ExitStrategy(),
		new ReturnLoopStrategy(),
	};
}