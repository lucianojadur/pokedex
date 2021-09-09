package iofiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import pokemon.Pokemon;

public class FileUpdater {

	private String _userName;
	private Collection<Pokemon> database;

	public FileUpdater(String userName, Collection<Pokemon> db){
		_userName = userName;
		database = db;
	}


	public boolean update(){
		BufferedWriter file = null;

		try{
			file = new BufferedWriter(new FileWriter(this._userName));
			
			for (Pokemon pokemon : database){
				List<String> values = pokemon.getValues();
				String line = String.join(",",values);
				try{
					file.write(line+"\n");
				} catch (IOException ex){
					System.out.println("Something went wrong while overwriting the database file");
					throw ex;
				}			
			}
			file.close();
		} catch(Exception e){
			System.out.println("Something went wrong while overwriting the database file");
			e.printStackTrace();
		}
		return true;
	}
}
