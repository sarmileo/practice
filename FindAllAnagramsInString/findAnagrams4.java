package FindAllAnagramsInString;

import java.util.*;
import java.util.stream.Collectors;

public class findAnagrams4 
{
    public static List<Integer> findAnagrams(String s, String p) 
    {
        int sLength = s.length(); 

        int startIndex = 0;
        int pLength = p.length();
        int endIndex = 0;
        List<Integer> indexes = new ArrayList<>();
        
        Map<Character, Long> pCharMap = p.chars()
                                        .mapToObj(e -> (char)e)
                                        .collect(
                                                Collectors.groupingBy(
                                                    e -> (char)e,
                                                    Collectors.counting()
                                                )
                                        ); 

        
        System.out.println("charMap : " + pCharMap); 
        Hashtable<Character, Long> subHash = new Hashtable<>();
        
        while ((startIndex + pLength) <= sLength)
        {             
            if(!pCharMap.containsKey(s.charAt(endIndex)))
            {
                startIndex++;
                endIndex++;
            }
            else
            {
                long v = subHash.getOrDefault(s.charAt(endIndex), 0L);
            
                subHash.compute(s.charAt(endIndex), (key, value) -> v + 1L);          

                endIndex++;           

                if(endIndex == startIndex + pLength)
                {
                    if(pCharMap.equals(subHash))
                    {
                        indexes.add(startIndex);
                    }                

                    startIndex++;
                    endIndex = startIndex;


                    System.out.println("sub: " + subHash);
                    System.out.println("--------------");   
                    subHash.clear();
                }
            }          
        }        
        
        return indexes;
    
    }

    public static void main(String[] args) 
    {
        //Test Cases: ("cbaebabacd", "abc")
        System.out.println("Anagrams indexes: " + findAnagrams("cbaebabacd", "abc"));            
    }
}