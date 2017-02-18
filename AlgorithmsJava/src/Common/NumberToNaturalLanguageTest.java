package Common;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NumberToNaturalLanguageTest {

	NumberToNaturalLanguage test;
	
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new NumberToNaturalLanguage();
	  }
	
	@Test
	public void test() {
		String result = test.GetNaturalLanguageVersion(1023456789);
		String expected = " one billion  twenty three million four houndred fifty six thousand seven houndred eighty nine";
		assertTrue(result.equals(expected));
	}	
}
