package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import types.Type;
import pokemon.Pokemon;
import pokedex.Pokedex;

public class Parser {

	static private Parser instance;
	private String _source;
	private String _user;
	private HashMap<String,Pokemon> _database;


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
		String delim = ",";


		try{
			reader = new BufferedReader(new FileReader(this._source));
			this._user = reader.readLine();
		
			while ((line = reader.readLine()) != null) {
				HashSet<String> abilities = new HashSet<String>();
				ArrayList<String> evolutions = new ArrayList<String>();
				
				String [] pokemonData = line.split(delim);
				int j = 2;
				//
				//List of Types
				int typesSize = Integer.parseInt(pokemonData[2]);
				HashSet<Type> types = new HashSet<Type>(typesSize); //initial size
				for (int i = 0; i < typesSize; i++){
					j++;
					types.add(Type.valueOf(pokemonData[j]));
				}j++;
				//
				//List of abilities
				int abilitiesSize = Integer.parseInt(pokemonData[2 + typesSize + 1]);
				for (int i = 0; i < abilitiesSize; i++){
					j++;
					abilities.add(pokemonData[j]);
				}
				//
				//List of evolutions
				for (int i = j+1;  i < pokemonData.length; i++){
					evolutions.add(pokemonData[i]);
				}

				Pokemon p = new Pokemon(
					pokemonData[0], 
					Integer.parseInt(pokemonData[1]),
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

}
