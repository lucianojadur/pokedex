import java.io.BufferedReader;
import java.io.FileReader;
import src.types.Type;
import src.pokemon.Pokemon;
import src.pokedex.Pokedex;


public class Parser {

	static private Parser instance;
	private String source;
	private String user;
	private ArrayList<Pokemon> pokemons;


	private Parser(String path){
		source = path;
	}

	public static create(path){
		if (instance == null || !source.equals(path))
			instance = new Parser(path);
		instance.parse();
		return instance;
	}
	
	public boolean parse(){
		BufferedReader reader = null;
		String line = "";
		String delim = ",";
		
		try{
			reader = new BufferedReader(new FileReader(path));
			this.user = reader.readLine();
		
			while ((line = reader.readLine()) != null) {
				String [] pokemonData = line.split(delim);
				//
				//List of Types
				int typesSize = pokemonData[2];
				ArrayList<Type> types = new ArrayList(typesSize); //initial size
				for (int i = 0; i < typesSize; i++)
					types.add(pokemonData[3+i]);
				//
				//List of abilities
				int abilitiesSize = pokemonData[2 + typesSize + 1];
				//
				//List of evolutions
				int evSize = 2 + tipesSize + abilitiesSize + 2;
				ArrayList<Pokemon> evolutions = new ArrayList(pokemons[evSize]);
				for (int i = 0; i < ; i++)
					evolutions.add(pokemons[evSize+i]);

				Pokemon p = new Pokemon(pokemons[0], pokemons[1], types, );
				
			}

		}
	}

}
