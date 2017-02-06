package Common;

import java.util.HashMap;
import java.util.Map;

public class ProjMorse {

    static String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " ", "?", ",", ".", ":", "-" };
    static String[] dottie = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "  ", "..--..", "--..--", 
            ".-.-.-", "---...", "-....-" };
        
    final static String WRONG = "Invalid Morse Code Or Spacing"; 
	public static String run(boolean morseToEnglish, String textToTranslate) {
		String translatedText = "";

		if (textToTranslate == null || textToTranslate == "")
		{			
			return WRONG;
		}
		
		if (morseToEnglish)
		{
			translatedText = toEnglish(textToTranslate.toCharArray());
		}
		else
		{
			translatedText = toMorse(textToTranslate.toCharArray());
		}
		return translatedText;
	}
	
	public static String toMorse(char [] translates)
    {            
	   String morse = "";
	   
	   Map<String, String> map = new HashMap<String, String>();
	   for (int i = 0; i < alpha.length; i++)
	   {
		   map.put(alpha[i], dottie[i]);
	   }
	   
	   for (int j = 0; j < translates.length; j++)
	   {
		     char a = translates[j];
		     morse += map.get(a);
	   }
	   return morse;
    }

	 public static String toEnglish(char [] translates)
	 {
	   String result = "";
	   
	   Map<String, String> map = new HashMap<String, String>();
	   for (int i = 0; i < alpha.length; i++)
	   {
		   map.put(dottie[i], alpha[i]);
	   }
	   
	   String word = "";
	   int spaces = 0;
	   for (int i = 0; i < translates.length; i++)
	   {
		   if (translates[i] != ' ')
		   {
			   word += translates[i];
			   spaces = 0;
		   }
		   else
		   {
			   spaces++;
			   
			   if (spaces == 1)
			   {			   
				   if (!map.containsKey(word))
				   {
					   return WRONG;
				   }
				   else
				   {
					   result += map.get(word);
					   word = "";
				   }
			   }
			   else
			   {
				   if (spaces == 3)
				   {
					   result += " ";
					   spaces = 0;
				   }				   
			   }
		   }
	   }
	   
	   if (spaces == 2)
	   {
		   return WRONG;
	   }
	   if (word != "")
	   {
		   if (!map.containsKey(word))
		   {
			   return WRONG;
		   }
		   else
		   {
			   result += map.get(word);
			   word = "";
		   }		   
	   }
	   return result;
	 }
}
