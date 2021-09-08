package parser;

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


	public static Parser getDataFrom(String path){
		if (instance == null || !path.equals(instance._source))
			instance = new Parser(path);

		return (instance.parse()) ? instance : null;
	}
	

	public HashMap<String, Pokemon> getDB(){
		return _database;
	}


	public String userName(){
		return _user;
	}


	public boolean parse(){
		BufferedReader reader = null;
		String line = "";

		try{
			reader = new BufferedReader(new FileReader(this._source));
			this._user = reader.readLine();
		
			while ((line = reader.readLine()) != null) {
				String [] pokemonData = line.split(DELIM);

				HashSet<Type> types = parseTypes(pokemonData);
				HashSet<String> abilities = parseAbilities(pokemonData, types.size() + 4);
				ArrayList<String> evolutions = parseEvolutions(pokemonData, types.size()+abilities.size()+5);
			
				Pokemon p = new Pokemon(
					pokemonData[0], 
					parseLevels(pokemonData[1], pokemonData[2]),
					types,
					abilities,
					evolutions);
				_database.putIfAbsent(p.name().toLowerCase(), p);
			}
			return true;
		}
		catch (Exception e) {	
			System.out.println("Ocurrió un error al procesar el archivo: " + this._source);
			System.out.println("Error: " + e);
			return false;
		}
	}


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


	private HashSet<Type> parseTypes(String[] data){
		int typesSize = Integer.parseInt(data[TYPES_SIZE_INDEX]);
		HashSet<Type> types = new HashSet<Type>();
		
		for (int i = FIRST_TYPE_INDEX; i < FIRST_TYPE_INDEX+typesSize; i++)
			types.add(Type.valueOf(data[i]));
		return types;
	}


	private HashSet<String> parseAbilities(String[] data, Integer from){
		int abilitiesSize = Integer.parseInt(data[from]);
		HashSet<String> abilities = new HashSet<String>();
		for (int i = from; i < from + abilitiesSize; i++)
			abilities.add(data[i]);
		return abilities;
	}


	private ArrayList<String> parseEvolutions(String[] data, Integer from){
		ArrayList<String> evolutions = new ArrayList<String>();
		for (int i = from;  i < data.length; i++)
			evolutions.add(data[i]);
		return evolutions;
	}

}

