package iofiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import types.Type;
import pokemon.Pokemon;
import pokedex.Pokedex;



public class Parser{

	static private Parser instance;
	private String _source;
	private String _user;
	private HashMap<String,Pokemon> _database;

	private final String DELIM = ",";
	private final int TYPES_SIZE_INDEX = 3;
	private final int FIRST_TYPE_INDEX = 4;


	private Parser(String path){
		_source = path;
		_database = new HashMap<String, Pokemon>();
	}

	//
	//Returns the only instance of parser given the relative url of a
	//correctly written data file.
	//If the file is corrupt, it returns null.
	public static Parser getDataFrom(String path){
		if (instance == null || !path.equals(instance._source))
			instance = new Parser(path);

		return (instance.parse()) ? instance : null;
	}
	
	//
	//It returns all pokemons registered in the parsed data file
	public HashMap<String, Pokemon> getDB(){
		return _database;
	}

	//
	//It returns the name of the user whose data is currently loaded to memory
	public String userName(){
		return _user;
	}

	//
	//Parses the CSV file whose path is linked to Singleton's attribute <_source>.
	//If the file is written correctly, it returns true, otherwise it returns false.
	private boolean parse(){
		BufferedReader reader = null;
		String line = "";

		try{
			reader = new BufferedReader(new FileReader(this._source));
			this._user = reader.readLine();
		
			while ((line = reader.readLine()) != null) {
				String [] pokemonData = line.split(DELIM);

				HashSet<Type> types = parseTypes(pokemonData);
				HashSet<String> abilities = parseAbilities(pokemonData, types.size() + 4);
				ArrayList<String> evols = parseEvolutions(pokemonData, types.size()+abilities.size()+5);
				ArrayList<String> prevs = parsePrevious(pokemonData, types.size()+abilities.size()+evols.size()+6);
			
				Pokemon p = new Pokemon(
					pokemonData[0], 
					parseLevels(pokemonData[1], pokemonData[2]),
					types,
					abilities,
					evols,
					prevs);

				this._database.putIfAbsent(p.name().toLowerCase(), p);
			}
			return true;
		}
		catch (Exception e) {	
			System.out.println("Ocurrió un error al procesar el archivo: " + this._source);
			System.out.println("Error: " + e);
			return false;
		}
	}

	//
	//Given 2 numbers as strings, it returns them parsed as integers.
	private Integer[] parseLevels(String lvFound, String lvMin){
		Integer[] lvs = new Integer[2];
		try{
			lvs[0] = Integer.parseInt(lvFound);
			lvs[1] = Integer.parseInt(lvMin);
		}catch(Exception e){
			lvs[0] = lvs[1] = 0;
		}
		return lvs;
	}

	//
	//Given a register, it returns the data of the fields corresponding to the type.
	private HashSet<Type> parseTypes(String[] data){
		int typesSize = Integer.parseInt(data[TYPES_SIZE_INDEX]);
		HashSet<Type> types = new HashSet<Type>();
		
		for (int i = FIRST_TYPE_INDEX; i < FIRST_TYPE_INDEX+typesSize; i++)
			types.add(Type.valueOf(data[i]));

		return types;
	}

	//
	//Given a register, it returns the data of the fields corresponding to the abilities.
	private HashSet<String> parseAbilities(String[] data, Integer sizeIndex){
		int abilitiesSize = Integer.parseInt(data[sizeIndex]);
		HashSet<String> abilities = new HashSet<String>();

		for (int i = 1; i <= abilitiesSize; i++)
			abilities.add(data[i+sizeIndex]);

		return abilities;
	}

	//
	//Given a register, it returns the data of the fields corresponding to the evolutions.
	private ArrayList<String> parseEvolutions(String[] data, Integer sizeIndex){
		int evSize = Integer.parseInt(data[sizeIndex]);
		ArrayList<String> evolutions = new ArrayList<String>();
		
		for (int i = 1;  i <= evSize; i++)
			evolutions.add(data[i+sizeIndex]);

		return evolutions;
	}

	//
	//Given a register, it returns the data of the fields corresponding to the pre-evolutions.
	private ArrayList<String> parsePrevious(String[] data, Integer sizeIndex){
		int prevSize = Integer.parseInt(data[sizeIndex]);
		ArrayList<String> previous = new ArrayList<String>();
		
		for (int i = 1;  i <= prevSize; i++)
			previous.add(data[i+sizeIndex]);

		return previous;
	}

}

