package FindAllAnagramsInString;

import java.util.*;
import java.util.stream.Collectors;

public class findAnagrams1 
{
    public static List<Integer> findAllAnagrams(String s, String p) 
    {
        int sLength = s.length();

        int startIndex = 0;
        int pLength = p.length();
        int endIndex = startIndex + pLength;
        List<Integer> indexes = new ArrayList<>();

        Set<Character> pChars = p.chars() 
                              .mapToObj(e -> (char)e)
                              .collect(Collectors.toSet()); 
        
        Map<Character, Long> charMap = p.chars()
                                            .mapToObj(e -> (char)e)
                                            .collect(
                                                        Collectors.groupingBy(
                                                            e -> (char)e,
                                                            Collectors.counting()
                                                        )
                                                    );
        
        //System.out.println("charMap : " + charMap);
        
        while (endIndex <= sLength)
        {
            if(s.indexOf(p) == startIndex)
            {
                indexes.add(startIndex);
                startIndex++;
                endIndex = startIndex  + pLength;
                continue;
            }
            
            String subString = s.substring(startIndex,  endIndex);
            //System.out.println("subString : " + subString);
            
            long count = 0;
            long total = 0;       

            for (Character c : pChars)
            {
                count =  subString.chars().filter(ch -> ch == c).count();    
                //System.out.println(c + ": " + count);

                if (count == pLength || charMap.get(c) != count)
                    break;
                
                total += count;
                count = 0;
            }

            if (total == pLength || count == pLength)
            {
                indexes.add(startIndex);
            }

            count = 0;
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