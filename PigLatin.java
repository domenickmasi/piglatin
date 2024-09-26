import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class PigLatin
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a sentence: ");
		String str = input.nextLine();
        		 	
		String piggie = Converter.convertSentence(str);
		System.out.println();
		System.out.println("Converted word: " + piggie);
        input.close();

    }
}

class Converter
{
	public static String convertWord(String s)
	{
        if(startsVowel(s))
        {
            //if starts vowel returns true, return the word and add "way"
            return s.toLowerCase()+"way";
        }
        if(startsConsonant(s))
        {
            //if starts consonant returns true, check if the second letter is a consonant
            if(isVowel(s.substring(1,2)))
            {
                //if second letter is vowel, take off the first letter and add it to the back with "ay"
                return (s.substring(1)).toLowerCase()+(s.substring(0,1)) + "ay";
            }
            else
            {
                //if second letter is consonant, take off the first 2 letters and add it to the back with "ay"
                return (s.substring(2)).toLowerCase() + s.substring(0,2) + "ay";
            }

        }
     	return "";      // This statement is provided to allow initial compiling.
	}  
    public static String convertSentence(String sentence)
    {
        //checks for one letter word
        if(sentence.length()>1)
        {
            //declare our output and space
            String converted = "";
            int space = 0;
            //repeat until a space can not be found
            do 
            {
                //find a space
                space = sentence.indexOf(" ");
                //if a space is found...
                if(space != -1)
                {
                    converted += convertWord(sentence.substring(0,space)) + " ";
                    sentence = sentence.substring(space+1);
                }
                //if a space is not found...
                else
                {
                    converted += convertWord(sentence);
                }
            }
            while (space != -1);
            return converted;
        }
        //checks if one-letter word is valid
        else if (startsVowel(sentence))
        {
            return(sentence + "way");
        }
        //checks if one-letter word is invalid
        else 
        {
            return("You can't do that, sport! Try again, pal! Better luck next time, BUD!");
        }
    }
    public static boolean isVowel(String a)
    {
        //declare isVowel variable
        boolean iv = false;
        //checks if the given letter is a vowel
        if(a.equals("a")||a.equals("e")||a.equals("i")||a.equals("o")||a.equals("u"))
        iv = true;

        return iv;
    }

    public static boolean startsVowel(String word0)
    {
        //substring the first letter and put it into isVowel
        String starter = word0.substring(0,1);
        return isVowel(starter);
    }

    public static boolean startsConsonant(String word1)
    {
        //substring the first letter and put it into isVowel
        String starter = word1.substring(0,1);
        //if isVowel returns false, it is a consonant
        return !isVowel(starter);
    }
}
