package LeetCode;

import org.junit.*;
import java.util.*;

public class Problem648_ReplaceWordsTest {

	Problem648_ReplaceWords test;
		 
	  @Before
	  public void setUp() throws Exception {
		  
		  test = new Problem648_ReplaceWords();
	  }
	
	@Test
	public void test() {
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		String sentence = "the cattle was rattled by the battery";
		String res = test.replaceWords(dict, sentence);
		Assert.assertTrue(res == "the cat was rat by the bat");
	}
}

