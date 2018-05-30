package passwordGenerator;

import java.util.Scanner;
import passwordFactory.PasswordFactory;

public class PasswordGenerator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PasswordFactory pf = new PasswordFactory();
		
		System.out.println("Entrer une phrase: ");
		String passPhrase = sc.nextLine();
		sc.close();
		
		System.out.println(pf.generateStrongPassword(passPhrase));


	}

	
	
}
