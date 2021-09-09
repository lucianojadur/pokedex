package output;

public interface ErrorMessages {
	
	public static final String MISSING_KEY = "The pokemon you're looking for does not exist or hasn't been registered yet.\n";

	public static final String WRONG_VALUE = "You entered a wrong value.\n";


	public abstract void printMsgError();
}