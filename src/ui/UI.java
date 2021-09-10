package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import iofiles.Parser;
import pokedex.Pokedex;
import pokemon.Pokemon;
import output.ErrorMessages;
import strategy.*;


public class UI 
	extends OptionSelector
	implements MainMenu, ErrorMessages, EscapeSequences
{

	private static Strategy mainMenu;
	private static Strategy edition;
	private static Pokedex pokedex;
	private static final String titlePath = "title.txt";


	//
	//It prints the title in a fancy format. 
	//Not tested on not-Unix-like systems, so it just prints a boring presentation in Windows.
	public static void printTitle(){
		System.out.println();
		if (System.getProperty("os.name").toLowerCase().equals("linux")){
			try{
				String line = "";
				BufferedReader reader = new BufferedReader(new FileReader(titlePath));
				while((line = reader.readLine()) != null)
					System.out.println(_WHITE_BACKGROUND_ + _RED_ + line + _RESET_);
			}
			catch(Exception e){
				System.out.println(_RED_ + "*** Welcome to Pokedex ***" + _RESET_);
			}
		}
		else
			System.out.println("*** Welcome to Pokedex ***");
	}

	//
	//Prints the main menu and asks the user for an option to choose.
	public static boolean mainMenu(){
		printMainMenu();
		String name = "";
		Integer option = askInputValue(6);
		
		mainMenu = mainStrategies[option];
		if(option > 0 && option < 5)
			name = askPokemonName();

		return mainMenu.executeQuery(name, pokedex);
	}

	//
	//Set up the start of the program.
	//It starts with default values in case of not addressing a source file
	//as an argument when executing the program.
	public static Pokedex initialize(String[] argv){
		Parser parser;
		if (argv.length != 1){
			parser = Parser.getDataFrom("database.csv");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Ingrese su nombre: ");
			pokedex = Pokedex.getInstance(parser.getDB(), scanner.nextLine() + ".csv");
		}else{
			parser = Parser.getDataFrom(argv[0]);
			pokedex = Pokedex.getInstance(parser.getDB(), argv[0]);
		}
		return pokedex;
	}

		//
		//Prints the visual interface for main menu
		private static void printMainMenu(){
			System.out.println("Choose any option: \n");
			System.out.println("1) See all pokemons");
			System.out.println("2) See one pokemon's data");
			System.out.println("3) See one pokemon special features");
			System.out.println("4) Edit pokemon");
			System.out.println("5) Add pokemon");
			System.out.println("6) Exit ");
			System.out.print(_CYAN_ +"\nInput: " + _RESET_);
		}


		public void printMsgError(){
			System.out.println(_RED_ + MISSING_KEY +_RESET_);
		}

		
		private static String askPokemonName(){
			System.out.print("\nWrite a name: ");
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine();
		}

}