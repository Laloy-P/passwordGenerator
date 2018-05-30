package passwordFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class PasswordFactory {


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
	
	public String lowerRandomly(String hash, int rand) {
		
		StringBuilder lowered = new StringBuilder();
		
		String start = hash.substring(0, rand);
		String end = hash.substring(rand +1, hash.length());
		char c = hash.charAt(rand);
		Character.toLowerCase(c);
		
		lowered.append(start);
		lowered.append(c);
		lowered.append(end);
		
		
		return lowered.toString();
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
	
	
	
}
