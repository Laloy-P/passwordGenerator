package passwordGenerator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		MessageDigest digest = null;
		Scanner sc = new Scanner(System.in);
		
		String passPhrase = null, hashSha256 = null , tempStart = null, tempEnd = null, lower = null;
		byte[] encodedhash = null;
		char[] speccialChar = {'@', '#', '&', '§', '!', 'à', '$', '|', '~', '=', '+', '*', 'ù', '%', '?', '_', '-'};
		int randNum, max, half;
		
		System.out.println("Entrer une phrase: ");
		passPhrase = sc.nextLine();
		sc.close();
		
		
		
		
		try {
			
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(passPhrase.getBytes(StandardCharsets.UTF_8));
			hashSha256 = DatatypeConverter.printHexBinary(encodedhash);

		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		max = hashSha256.length();
		half = max/2;
	
		randNum = (int)(Math.random() * ((hashSha256.length())));
		
		
		tempStart = hashSha256.substring(0,randNum-1);
		tempEnd = hashSha256.substring(randNum + 1, hashSha256.length());
		lower = hashSha256.substring(randNum).toLowerCase();
		

		for (int i = 0; i < half ;i++) {
			
			
			
		}

	}

	
	
}
