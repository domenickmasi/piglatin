import java.util.Scanner;

public class PigLatin
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = input.nextLine();
        		 	
		String piggie = Converter.convertWord(str);
		System.out.println();
		System.out.println("Converted word: " + piggie);
        input.close();

    }
}

class Converter
{
	/*
	 * Precondition:  s is a String containing a single word.
	 * Postcondition: returns a word converted into Pig Latin according to the appropriate rule.
 	 * Most words in Pig Latin end in "ay." Use the rules below to translate normal English into Pig Latin.
     * 1. If a word starts with a consonant and a vowel, put the first letter of the word at the end of the word and add "ay."
     * Example: Happy = appyh + ay = appyhay
     * 2. If a word starts with two consonants move the two consonants to the end of the word and add "ay."
     * Example: Child = Ildch + ay = Ildchay
     * 3. If a word starts with a vowel add the word "way" at the end of the word.
     * Example: Awesome = Awesome +way = Awesomeway
	 */
	public static String convertWord(String s)
	{
        String newWord = s.substring(1);

        if(startsVowel(s))
        {
            //newWord+=s.substring(0,1)+"way";
            return s.toLowerCase()+"way";
        }
        if(startsConsonant(s))
        {
            return newWord.toLowerCase()+"ay";
        }
     	return "";      // This statement is provided to allow initial compiling.
	}  
    
    public static boolean isVowel(String a)
    {
        boolean iv = false;
        if(a.equals("a")||a.equals("e")||a.equals("i")||a.equals("o")||a.equals("u"))
        iv = true;

        return iv;
    }

    public static boolean startsVowel(String word0)
    {
        String starter = word0.substring(0,1);
        return isVowel(starter);
    }

    public static boolean startsConsonant(String word1)
    {
        String starter = word1.substring(0,1);
        return !isVowel(starter);
    }

   
}
