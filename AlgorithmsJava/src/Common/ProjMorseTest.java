package Common;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProjMorseTest {

	ProjMorse test;
	
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new ProjMorse();
	  }
	
	@Test
	public void test() {
		String result = test.run(true, "... --- ..."); 
		assertTrue(result == "sos");
	}
	
	@Test
	public void test2() {
		String result = test.run(true, "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-.-.-"); 
		assertTrue(result == "the wizard quickly jinxed the gnomes before they vaporized.");
	}
	
	
}
