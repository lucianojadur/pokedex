package pokemon;

import java.util.HashSet;
import java.util.ArrayList;
import java.io.*;
import types.Type;


public class Pokemon {
	
	protected String _name;
	protected final Integer _foundLevel;
	private final Integer _initialLevel;
	private HashSet<Type> _types;
	private HashSet<String> _abilities;
	private ArrayList<String> _evolutions;

	public Pokemon(String name, Integer[] levels){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_types = new HashSet<Type>();
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}



	public Pokemon(String name, Integer[] levels, Type t){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_types = new HashSet<Type>();
		_types.add(t);
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}


	public Pokemon(String name, Integer[] levels, HashSet<Type> types){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}

	public Pokemon(
		String name, 
		Integer[] levels, 
		HashSet<Type> types, 
		HashSet<String> abilities, 
		ArrayList<String> evolutions
	){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>(abilities);
		_evolutions = new ArrayList<String>(evolutions);
	}


	public Pokemon(Pokemon p){
		_name = p._name;
		_foundLevel = p._foundLevel;
		_initialLevel = p._initialLevel;
		_types = new HashSet<Type>(p._types);
		_abilities = new HashSet<String>(p._abilities);
		_evolutions = new ArrayList<String>(p._evolutions);
	}


	public String name(){
		return _name;
	}


	public Integer level(){
		return _foundLevel;
	}


	public Integer minLv(){
		return _initialLevel;
	}


	public HashSet<String> abilities(){
		return _abilities;
	}


	public void levelUp(Integer lv){
//		_foundLevel += lv;
	}
	

	public boolean addType(Type t){
		return _types.add(t);
	}


	public HashSet<Type> types(){
		return _types;
	}

	public boolean removeType(Type t){
		try{
			_types.remove(t);
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}


	public void changeName(String name){
		_name = name;
	}


	public void addEvolution(String name){
		_evolutions.add(name);
	}

	public HashSet<String> showAbilities(){
		return _abilities;
	}

	public ArrayList<String> evolutions(){
		return _evolutions;
	}

}	




