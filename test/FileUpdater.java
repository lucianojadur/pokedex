import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;

public class FileUpdater {

	private String _fileName;
	private Collection<Pokemon> database;

	public FileUpdater(String path, Collection<Pokemon> db){
		_fileName = path;
		database = db;
	}

	//
	//Rewrites (in case of existing previously, otherwise it just creates it) the file
	//with all the database information statically storaged in it.
	//
	//As this method is called, the database storaged in the computer remains updated;
	public boolean update(){
		BufferedWriter file = null;

		try{
			file = new BufferedWriter(new FileWriter(this._fileName));
			
			file.write(_fileName+"\n");

			for (Pokemon pokemon : database){
				List<String> values = pokemon.getValues();
				String line = String.join(",",values);
				try{
					file.write(line+"\n");
				} catch (IOException ex){
					System.out.println("Something went wrong while overwriting the database file");
					file.close();
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
