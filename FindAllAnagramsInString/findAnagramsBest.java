package FindAllAnagramsInString;

import java.util.*;
import java.util.stream.Collectors;

public class findAnagramsBest 
{
    public static List<Integer> findAnagrams(String s, String p) {

        int startIndex = 0;
        int endIndex = 0;
        int pLength = p.length();
        int sLength = s.length(); 

        List<Integer> indexes = new ArrayList<>();
        
        Map<Character, Long> pCharMap = p.chars()
                                        .mapToObj(e -> (char)e)
                                        .collect(
                                                Collectors.groupingBy(
                                                    e -> (char)e,
                                                    Collectors.counting()
                                                )
                                        ); 

        //System.out.println("charMap : " + pCharMap); 
        Hashtable<Character, Long> subHash = new Hashtable<>();
        
        while ((startIndex + pLength) <= sLength)
        {  
            long v = subHash.getOrDefault(s.charAt(endIndex), 0L);

            subHash.compute(s.charAt(endIndex), (key, value) -> v + 1L);          

            endIndex++;           

            if(endIndex - 1 >= pLength - 1)
            {
                if(pCharMap.equals(subHash))
                {
                    indexes.add(startIndex);
                }  

                //System.out.println("sub: " + subHash);
                //System.out.println("--------------");

                if(subHash.get(s.charAt(startIndex)) > 1)
                    subHash.compute(s.charAt(startIndex), (key, value) -> value - 1L); 
                else
                    subHash.remove(s.charAt(startIndex));

                startIndex++;
            }        
        }        
        
        return indexes;
    }

    public static void main(String[] args) 
    {
        //Test Case: ("cbaebabacd", "abc"), Passed all test cases in Leetcode
        System.out.println("Anagrams indexes: " + findAnagrams("cbaebabacd", "abc"));            
    }
    
}