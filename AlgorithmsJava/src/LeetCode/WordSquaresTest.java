package LeetCode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class WordSquaresTest {

	@Test
	public void testWordSquares() {
		
		WordSquares test = new WordSquares();
		String[] words = new String[5];
		words[0] = "area";
		words[1] = "lead";
		words[2] = "wall";
		words[3] = "lady";
		words[4] = "ball";
		
		List<List<String>> res = test.wordSquares(words);		
	}
}
