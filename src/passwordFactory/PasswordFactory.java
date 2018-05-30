package passwordFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class PasswordFactory {
	
	public String generateStrongPassword(String input) {
		String password = null;
		int rand = (int)(Math.random() * 500000);
		
		password = addSpecialChar(lowerRandomly(sliceHash(generateHash(input), 15, rand)));
		
		return password;
	}

	public String generateHash(String passPhrase) {
		String hash = null;
		byte[] encodedhash = null;
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(passPhrase.getBytes(StandardCharsets.UTF_8));
			hash = DatatypeConverter.printHexBinary(encodedhash);

		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
		
		return hash;
	}
	
	public String sliceHash(String hash, int passSize, int rand) {
		
		String slice;
		
		int maxRandSize = hash.length() - passSize;
		
		if (rand > maxRandSize) {
			slice = hash.substring(maxRandSize, hash.length());
		}else {
			slice = hash.substring(rand, rand +passSize);
		}
		
		return slice;
	}
	
	public String lowerRandomly(String hash) {
		
		StringBuilder lowered = new StringBuilder();

		for (int i = 0; i < hash.length(); i++) {
			
			String str = hash.substring(i,i+1);
			char c = str.charAt(0);
			int val = (int) c *(int)(Math.random() * 500000);

			if (val %2 == 0) {
				lowered.append(str.toLowerCase());
			}else {
				lowered.append(str);
			}	
		}

		return lowered.toString();
	}
	
	public String addSpecialChar(String hash) {
		StringBuilder password = new StringBuilder();
		char[] specialChar = {'@', '#', '&', '§', '!', 'à', '$', '|', '~', '=', '+', '*', 'ù', '%', '?', '_', '-'};
		
		for (int i = 0; i < hash.length(); i++) {
			
			int indexRandomChar = (int)(Math.random() * specialChar.length);
			String str = hash.substring(i,i+1);
			char c = str.charAt(0);
			int val = (int) c *(int)(Math.random() * 500000);

			if (val %7 == 0) {
				password.append(str);
				password.append(specialChar[indexRandomChar]);
			}else {
				password.append(str);
			}	
		}
		
		
		return password.toString();
	}
	
	
}
