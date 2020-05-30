package FindAllAnagramsInString;

import java.util.*;

public class findAnagrams2 
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
            Hashtable<Integer, Character> charTable = new Hashtable<>();
                
            for (int j = 0; j < substring.length(); j++)
            {
                charTable.put(j, substring.charAt(j));
            }
            
            //System.out.println(charTable);
            
            boolean check = false;

            for (int i = 0; i < pLength; i ++)
            {                
                if (charTable.contains(p.charAt(i)))
                {
                    check = true;
                    charTable.remove(substring.indexOf(p.charAt(i)));
                    //System.out.println(charTable);
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