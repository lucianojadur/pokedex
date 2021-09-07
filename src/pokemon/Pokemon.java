package pokemon;

import java.util.ArrayList;
import java.io.*;
import types.Type;


public class Pokemon {
	
	protected String _name;
	protected Integer _level;
	private Integer _initialLevel;
	private ArrayList<Type> _types;
	private ArrayList<String> _abilities;
	private ArrayList<Pokemon> _evolutions;


	public Pokemon(String name, Integer level, Type t){
		_name = name;
		_level = level;
		_initialLevel = level;
		_types = new ArrayList<Type>();
		_types.add(t);
		_abilities = new ArrayList<abilities>();
		_evolutions = new ArrayList<String>();
	}


	public Pokemon(String name, Integer level, ArrayList<Type> types){
		_name = name;
		_level = level;
		_initialLevel = _level;
		_types = new ArrayList<Type>(types);
		_abilities = new ArrayList<abilities>();
		_evolutions = new ArrayList<String>();
	}


	public Pokemon(Pokemon p){
		_name = p._name;
		_level = p._level;
		_initialLevel = p._level;
		_types = new ArrayList<Type>(p._types);
		_abilities = new ArrayList<abilities>(p._abilities);
		_evolutions = new ArrayList<String>(p._evolutions);
	}


	public String name(){
		return _name;
	}


	private void evolve(){
		try{
			//evolucionar / State
		}catch(ArrayIndexOutOfBoundsException e){
			//enviar error
		}
	}


	public void levelUp(Integer lv){
		_level += lv;
//		if (_level == /*nivel minimo del siguiente*/)
//			String prevName = _name;
//			evolve();
//			System.out.println(prevName + "has evolve to " + _name);
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


	public void addEvolution(Stirng name){
		_evolutions.add(name);
	}

	public void showAbilities(){
		System.out.println(_name + "'s abilities: | ");
		for (String a : _abilities)
			System.out.println(a + " | ");
	}

	public void showEvolutions(){
		if(!_evolutions.isEmpty()){	
			System.out.println(_name + "'s Evolutions: ");
			for (String p : _evolutions)
				System.out.println(p + " | ");
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




