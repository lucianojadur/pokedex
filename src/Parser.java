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
				String [] pokemons = line.split(delim);
				
			}

		}
	}

}
