package pokemon;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import types.Type;


public class Pokemon {
	
	protected String _name;
	protected final Integer _foundLevel;
	protected final Integer _initialLevel;
	protected Integer _level;
	private HashSet<Type> _types;
	private HashSet<String> _abilities;
	private ArrayList<String> _evolutions;
	private ArrayList<String> _previous;

	public Pokemon(String name, Integer[] levels){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_level = _foundLevel;
		_types = new HashSet<Type>();
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}



	public Pokemon(String name, Integer[] levels, Type t){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_level = _foundLevel;
		_types = new HashSet<Type>();
		_types.add(t);
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
		_previous = new ArrayList<String>();

	}


	public Pokemon(String name, Integer[] levels, HashSet<Type> types){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_level = _foundLevel;
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
		_previous = new ArrayList<String>();
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
		_level = _foundLevel;
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>(abilities);
		_evolutions = new ArrayList<String>(evolutions);
		_previous = new ArrayList<String>();
	}


	public Pokemon(
		String name, 
		Integer[] levels, 
		HashSet<Type> types, 
		HashSet<String> abilities, 
		ArrayList<String> evolutions,
		ArrayList<String> previous
	){
		_name = name;
		_foundLevel = levels[0];
		_initialLevel = levels[1];
		_level = _foundLevel;
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>(abilities);
		_evolutions = new ArrayList<String>(evolutions);
		_previous = new ArrayList<String>(previous);
	}


	public Pokemon(Pokemon p){
		_name = p._name;
		_foundLevel = p._foundLevel;
		_initialLevel = p._initialLevel;
		_level = p._level;
		_types = new HashSet<Type>(p._types);
		_abilities = new HashSet<String>(p._abilities);
		_evolutions = new ArrayList<String>(p._evolutions);
		_previous = new ArrayList<String>(p._previous);

	}


	public String name(){
		return _name;
	}


	public Integer levelWhenFound(){
		return _foundLevel;
	}


	public Integer minLv(){
		return _initialLevel;
	}


	public Integer level(){
		return _level;
	}


	public void levelUp(Integer lv){
		_level += lv;
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


	public void changeName(String newName){
		_name = newName;
	}


	public void addEvolution(String name){
		_evolutions.add(name);
	}


	public HashSet<String> abilities(){
		return _abilities;
	}


	public ArrayList<String> evolutions(){
		return _evolutions;
	}


	public ArrayList<String> previous(){
		return _previous;
	}

	public List<String> getValues(){
		try{
			List<String> values = new ArrayList<String>();
			values.add(_name);
			values.add(String.valueOf(_foundLevel));
			values.add(String.valueOf(_initialLevel));
			values.add(String.valueOf(_types.size()));
			for (Type t : _types)
				values.add(t.name());
			values.add(String.valueOf(_abilities.size()));
			for (String a : _abilities)
				values.add(a);
			values.add(String.valueOf(_evolutions.size()));
			for (String e : _evolutions)
				values.add(e);
			values.add(String.valueOf(_previous.size()));
			for (String prev : _previous)
				values.add(prev);
	
			return values;
		}
		catch (NullPointerException e){
			return null;
		}
	}

}	




