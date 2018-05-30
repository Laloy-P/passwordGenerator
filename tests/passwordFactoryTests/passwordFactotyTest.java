package passwordFactoryTests;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import passwordFactory.PasswordFactory;

public class passwordFactotyTest {

	private String passPhrase;
	private String expectedHash;
	PasswordFactory passFactory; 
	
	@Before
	public void setUp() throws Exception {
		passPhrase = "demain";
		expectedHash = "8D87F74739C36A01A7800C7C80090B72158250F824C3DB7B9A1809F876B64046"; //  hash generated from https://passwordsgenerator.net/sha256-hash-generator/
		passFactory = new PasswordFactory();
	}

	@After
	public void tearDown() throws Exception {
		passPhrase =null;
		passFactory = null;
		
	}

	@Test
	public void generateHashTest() {

		assertThat(passFactory.generateHash(passPhrase), equalTo(expectedHash));
		
	}
	
	@Test
	public void lowerHashTest() {
		
		String hash = "C3DB7B9A1809F";
		String expected = "c3dB7B9A1809F";
		assertThat(passFactory.lowerRandomly(hash), equalTo(expected));
		
	}
	
	@Test
	public void sliceHashTest()
	{
		String expectedHash1 = "8D87F";
		String expectedHash2 = "C36A0";
		String expectedHash3 = "64046";
		
		
		assertThat (passFactory.sliceHash(passFactory.generateHash(passPhrase), 5, 0), equalTo(expectedHash1));
		assertThat (passFactory.sliceHash(passFactory.generateHash(passPhrase), 5, 10), equalTo(expectedHash2));
		assertThat (passFactory.sliceHash(passFactory.generateHash(passPhrase), 5, 62), equalTo(expectedHash3));
		
		
		
	}
	

}
