package passwordGenerator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import passwordFactory.PasswordFactory;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		MessageDigest digest = null;
		Scanner sc = new Scanner(System.in);
		
		String passPhrase = null, hashSha256 = null , tempStart = null, tempEnd = null, lower = null;
		byte[] encodedhash = null;
		char[] speccialChar = {'@', '#', '&', '§', '!', 'à', '$', '|', '~', '=', '+', '*', 'ù', '%', '?', '_', '-'};
		int randNum, max, half;
		/*
		System.out.println("Entrer une phrase: ");
		passPhrase = sc.nextLine();
		sc.close();
		*/
		

		
		
		
		PasswordFactory pf = new PasswordFactory();
		String s = "POMME";
		System.out.println(pf.generateStrongPassword(s));
		
	

	}

	
	
}
