
import pokemon.Pokemon;
import pokedex.Pokedex;
import types.Type;
import iofiles.Parser;
import ui.UI;

public class main{
	public static void main(String[] argv){
		Pokedex p = UI.initialize(argv);

	//	UI ui = new UI(p);
		UI.printTitle();

		boolean option = true;			
		while(option){
			option = UI.mainMenu();
		}	
	}
}
