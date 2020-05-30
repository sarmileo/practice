package FindAllAnagramsInString;

import java.util.*;
import java.util.stream.Collectors;

public class findAnagrams 
{
    public static List<Integer> findAllAnagrams(String s, String p) 
    {
        int sLength = s.length();

        int startIndex = 0;
        int pLength = p.length();
        int endIndex = startIndex + pLength;
        List<Integer> indexes = new ArrayList<>();

        Map<Character, Long> pCharMap = p.chars().mapToObj(e -> (char) e)
                                            .collect(
                                                Collectors.groupingBy(
                                                    e -> (char) e, 
                                                    Collectors.counting()
                                                )
                                            );

        while (endIndex <= sLength) 
        {
            String subString = s.substring(startIndex, endIndex);
            Map<Character, Long> subsCharMap = subString.chars().mapToObj(e -> (char) e)
                                                .collect(
                                                    Collectors.groupingBy(
                                                        e -> (char) e, 
                                                        Collectors.counting()
                                                    )
                                                );

            if (subsCharMap.equals(pCharMap)) 
            {
                indexes.add(startIndex);
            }

            startIndex++;
            endIndex = startIndex + pLength;
        }

        return indexes;
    }

    public static void main(String[] args) 
    {
        //Test Cases: ("cbaebabacd", "abc")
        System.out.println("Anagrams indexes: " + findAllAnagrams("cbaebabacd", "abc"));            
    }

}