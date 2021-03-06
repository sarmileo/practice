package longestSubstringNoRepeatChar;

import java.util.*;

public class longestSubstring {

    public static int lengthOfLongestSubstring(String s) 
    {   
        // if string is empty, just return      
        if (s.isEmpty())
            return 0;
        
        Set<Character> charSet = new HashSet<>();
        TreeSet<Integer> subsLengthSet = new TreeSet<>();
        char[] charArray = s.toCharArray(); 
        
        int startPos = 0;
        charSet.add(charArray[startPos]);
        
        if(s.length() == 1)
        {
            subsLengthSet.add(charSet.size());
        }
        else
        {
            /** The end position will advance until it finds a repeating character
             *  The start position will advance if a repeating character is found
             *  If the end position reach the end of the string, we should have 
             *    the longest size of the substring without repeating characters
             */
            int endPos = startPos + 1;
        
            while (endPos != charArray.length)
            {
                if (!charSet.contains(charArray[endPos]))
                {
                    charSet.add(charArray[endPos]);
                    endPos++;
                }
                else
                {
                    subsLengthSet.add(charSet.size());
                    charSet.clear();
                    
                    startPos++;
                    charSet.add(charArray[startPos]);
                    
                    endPos = startPos + 1;
                } 
                
                if(endPos == charArray.length)
                {
                    subsLengthSet.add(charSet.size());
                }
            }
        }
        
        System.out.println("Substrings lengths Set: " + subsLengthSet);
        int value = 0;
        
        if (!subsLengthSet.isEmpty())
        {
            value = subsLengthSet.pollLast();
        }       
        
        return value;
    }

    public static void main(String[] args) 
    {
        //Test Cases: "abcabcbb", " ", "au", "aab"
        System.out.println("Longest substring length: " + lengthOfLongestSubstring("aab"));            
    }
}