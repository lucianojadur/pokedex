package types;

import java.util.TreeSet;

public  class Type{
	private String _name;
	private TreeSet<Type> weakness;
	

	public Type(String name){
		_name = name;
		weakness = new TreeSet<Type>();
	}

	public Type(String name, Type w){
		_name = name;
		if (weakness == null)
			weakness = new TreeSet<Type>();
		weakness.add(w);
	}

	public Type(String name, TreeSet<Type> w){
		_name = name;
		weakness = new TreeSet<Type>(w);
	}

	public String name(){
		return _name;
	}

	public TreeSet<Type> trheats(){
		return weakness;
	}

	//@Override
	public boolean equals(Type t){
		return this._name.equalsIgnoreCase(t._name);
	}

}




