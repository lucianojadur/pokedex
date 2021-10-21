<div align="center">
        _______  _______  __   __  ______  __       ______ /\     _/ _/  
       / ___  / / ___  / / / _/_/ / ____/ /  \     / ____/ \ \  _/ _/    
      / /__/ / / /  / / / /_/_/  / /__   / /\ \   / /__     \ \/ _/      
     / _____/ / /  / / /   _/   / ___/  / /  ) ) / ___/      )  (        
    / /      / /__/ / / /\ \   / /___  / /_-¨ / / /___    _/¨_/\ \       
   /_/      /______/ /_/  \_\ /_____/ /_____/¨ /_____/  _/ _/   \ \      
                                                      _/ _/      \ |     
                                                     /__/         \|    
</div>
A naive implementation of a basic interactive-pokedex - the main Pokemon database- for run on Console. Written in Java for Unix-based OSs.

# EXECUTION
	
	$ ./main [username.csv]
	
	[username.csv] is an optional argument in case of the user has previously initialized the application with that <username> id.


If not existing [username.csv] file, it'll ask the user for its username and create a new file with that username from a default database file included in the repo once modified that initial database or after quiting the program.
