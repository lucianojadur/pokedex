package ui;

import strategy.*;

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