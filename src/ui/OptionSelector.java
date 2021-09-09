package ui;

import java.util.Scanner;

public class OptionSelector implements EscapeSequences{
	
	public static Integer askInputValue(int max){		
		Scanner scanner = new Scanner(System.in);
		try{
			Integer input = Integer.parseInt(scanner.nextLine());
			if (input < 1 || input > max)
				return max;
			return input-1;
		}catch(NumberFormatException e){
			System.out.println(_RED_ + "Choose a correct option." + _RESET_); 
			return max;
		}
	}
}