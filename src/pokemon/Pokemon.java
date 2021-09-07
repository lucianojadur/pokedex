package pokemon;

import java.util.ArrayList;
import java.io.*;
import types.Type;


public class Pokemon {
	protected String _name;
	protected Integer _level;
	private Integer _initialLevel;
	private ArrayList<Type> _types;
	private ArrayList<Pokemon> _evolutions;


	public Pokemon(String name, Integer level, Type t){
		_name = name;
		_level = level;
		_initialLevel = level;
		_types = new ArrayList<Type>();
		_types.add(t);
	}

	public Pokemon(String name, Integer level, ArrayList<Type> types){
		_name = name;
		_level = level;
		_initialLevel = _level;
		_types = new ArrayList<Type>(types);
	}

	public Pokemon(Pokemon p){
		_name = p._name;
		_level = p._level;
		_initialLevel = p._level;
		_types = new ArrayList<Type>(p._types);
		_evolutions = new ArrayList<Pokemon>(p._evolutions);
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

	public void changeName(String name){
		_name = name;
	}

	public void addEvolution(Pokemon e){
		_evolutions.add(e);
	}

	public void showData(){
		System.out.println("Name: " + _name);
		printTypes();
		System.out.println("Level: " + _level + "\n");
	}

	private void printTypes(){
		System.out.print("Type(s): | ");
		Integer i = 0;
		while (i < _types.size()){
			System.out.print(_types.get(i).name() + " | ");
			i++;
		}
		System.out.println();
	}

}	




