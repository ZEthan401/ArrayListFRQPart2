import java.util.ArrayList;

public class WordScramble
{
    /** Scrambles a given word.
     *
     *  @param word  the word to be scrambled
     *  @return  the scrambled word (possibly equal to word)
     *
     *  Precondition: word is either an empty string or contains only uppercase letters.
     *  Postcondition: the string returned was created from word as follows:
     *  - the word was scrambled, beginning at the first letter and continuing from left to right
     *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     *  - letters were swapped at most once
     */
    public static String scrambleWord(String word)
    {
        int currentIdx = 0;
        String result = "";

        while (currentIdx < word.length() - 1)
        {
            if (word.substring(currentIdx, currentIdx + 1).equals("A")
            && !word.substring(currentIdx + 1, currentIdx + 2).equals("A"))
            {
                result += word.substring(currentIdx + 1, currentIdx + 2);
                result += "A";
                currentIdx += 2;
            }
            else
            {
                result += word.substring(currentIdx, currentIdx + 1);
                currentIdx++;
            }
        }
        if (currentIdx < word.length())
        {
            result += word.substring(currentIdx);
        }
        return result;
    }

    /** Modifies wordList by replacing each word with its scrambled
     *  version, removing any words that are unchanged as a result of scrambling.
     *
     *  @param wordList the list of words
     *
     *  Precondition: wordList contains only non-null objects
     *  Postcondition:
     *  - all words unchanged by scrambling have been removed from wordList
     *  - each of the remaining words has been replaced by its scrambled version
     *  - the relative ordering of the entries in wordList is the same as it was
     *    before the method was called
     */
    public static void scrambleOrRemove(ArrayList<String> wordList)
    {
        int index = 0;
        while (index < wordList.size())
        {
            String word = wordList.get(index);
            String scrambled = scrambleWord(word);
            if (word.equals(scrambled))
            {
                wordList.remove(index);
            }
            else
            {
                wordList.set(index, scrambled);
            }
        }
    }
}