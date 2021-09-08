package pokemon;

import java.util.HashSet;
import java.util.ArrayList;
import java.io.*;
import types.Type;


public class Pokemon {
	
	protected String _name;
	protected Integer _level;
	private Integer _initialLevel;
	private HashSet<Type> _types;
	private HashSet<String> _abilities;
	private ArrayList<String> _evolutions;

	public Pokemon(String name, Integer level){
		_name = name;
		_level = level;
		_initialLevel = level;
		_types = new HashSet<Type>();
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}



	public Pokemon(String name, Integer level, Type t){
		_name = name;
		_level = level;
		_initialLevel = level;
		_types = new HashSet<Type>();
		_types.add(t);
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}


	public Pokemon(String name, Integer level, HashSet<Type> types){
		_name = name;
		_level = level;
		_initialLevel = _level;
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>();
		_evolutions = new ArrayList<String>();
	}

	public Pokemon(
		String name, 
		Integer level, 
		HashSet<Type> types, 
		HashSet<String> abilities, 
		ArrayList<String> evolutions
	){
		_name = name;
		_level = level;
		_initialLevel = _level;
		_types = new HashSet<Type>(types);
		_abilities = new HashSet<String>(abilities);
		_evolutions = new ArrayList<String>(evolutions);
	}


	public Pokemon(Pokemon p){
		_name = p._name;
		_level = p._level;
		_initialLevel = p._level;
		_types = new HashSet<Type>(p._types);
		_abilities = new HashSet<String>(p._abilities);
		_evolutions = new ArrayList<String>(p._evolutions);
	}


	public String name(){
		return _name;
	}


	public void levelUp(Integer lv){
		_level += lv;
	}
	

	public boolean addType(Type t){
		return _types.add(t);
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

	public void showAbilities(){
		System.out.print(_name + "'s abilities: | ");
		for (String a : _abilities)
			System.out.print(a + " | ");
		System.out.println();
	}

	public void showEvolutions(){
		if(!_evolutions.isEmpty()){	
			System.out.print(_name + "'s Evolutions: ");
			for (String p : _evolutions)
				System.out.print(p + " | ");
			System.out.println();
		}else
			System.out.println("There are not evolutions for " + _name);
	}

	public void showData(){
		System.out.println("Name: " + _name);
		printTypes();
		System.out.println("Level: " + _level + "\n");
	}

		private void printTypes(){
			System.out.print("Type(s): | ");
			for(Type t : _types)
				System.out.print(t.name() + " | ");
			System.out.println();
		}

}	




