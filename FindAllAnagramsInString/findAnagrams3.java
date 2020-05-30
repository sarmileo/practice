package FindAllAnagramsInString;

import java.util.*;

public class findAnagrams3 
{
    public static List<Integer> findAllAnagrams(String s, String p) 
    {
        int sLength = s.length();

        int startIndex = 0;
        int pLength = p.length();
        int endIndex = startIndex + pLength;
        List<Integer> indexes = new ArrayList<>();
        
        while (endIndex <= sLength)
        {
            String substring = s.substring(startIndex,  endIndex);
            StringBuilder sb = new StringBuilder(substring);
            boolean check = false;

            for (int i = 0; i < pLength; i ++)
            {
                int indexOfChar = sb.indexOf(Character.toString(p.charAt(i)), 0);
                
                if (indexOfChar != -1)
                {
                    check = true;
                    sb.deleteCharAt(indexOfChar);
                    continue;
                }
                else
                {
                    check = false;
                    break;
                }
            }

            if (check)
            {
                indexes.add(startIndex);
            }

            startIndex++;
            endIndex = startIndex  + pLength;
        } 

        return indexes;
    }

    public static void main(String[] args) 
    {
        //Test Cases: ("cbaebabacd", "abc")
        System.out.println("Anagrams indexes: " + findAllAnagrams("cbaebabacd", "abc"));            
    }

}