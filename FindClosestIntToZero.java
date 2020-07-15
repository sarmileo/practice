import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class FindClosestIntToZero 
{
    public static int findClosestHelper(int positiveD, int negativeD)
    {
        int closest = 0; 

        if (positiveD != 0 || negativeD != 0)
        {
            if (positiveD != 0 && negativeD == 0)
            {
                closest = positiveD;
            }
            else if (positiveD == 0  && negativeD != 0)
            {
                closest = negativeD * (-1);
            }
            else if(positiveD <= negativeD)
            {
                closest = positiveD;
            }
            else if(positiveD > negativeD)
            {
                closest = negativeD * (-1);
            }
        }

        return closest;
    }

    public static int findClosest(int[] a)
    {
        int closest = Integer.MAX_VALUE;
        int positiveD = 0;
        int negativeD = 0;
        
        for(Integer i : a)
        {
            if(i > 0)
            {              
                if(i < closest)
                {
                    closest = i;
                    positiveD = closest;
                }
            }
        }

        closest = Integer.MAX_VALUE;

        for(Integer i : a)
        {
            if(i < 0)
            {
                i = Math.abs(i);
                if (i < closest)
                {
                    closest = i;
                    negativeD = closest;
                }
            }
        }

        closest = findClosestHelper(positiveD, negativeD);

        return closest;
    }

    public static int findClosestUsingStream(int[] a)
    {
        int closestValue = 0;
        int positiveD = 0;
        int negativeD = 0;

        // positive number closest to zero
        OptionalInt min = Arrays.stream(a)
                                .filter(i -> i > 0)
                                .min();

        // negative number closest to zero
        OptionalInt max = Arrays.stream(a)
                                .filter(i -> i < 0)
                                .max();
            
        // could also check using min.isPresent()
        if(min.isPresent() || max.isPresent())
        {
            positiveD = min.orElse(0);
            negativeD = Math.abs(max.orElse(0));
    
            closestValue = findClosestHelper(positiveD, negativeD);
        }

        return closestValue;
    }

    public static int findClosestOnePass(int[] a)
    {
        int closestValue = Integer.MAX_VALUE;
        int outValue = 0;
        int positiveD = 0;
        int negativeD = 0;

        for(Integer v : a)
        {
            boolean checkNegative = false;

            if(v <= closestValue && v != 0)
            {
                if(v < 0)
                {
                    v = Math.abs(v);
                    checkNegative = true;
                }

                closestValue = v;

                if(checkNegative)
                {
                    negativeD = closestValue;
                }
                else
                {
                    positiveD = closestValue;
                }
            }
        }

        outValue = findClosestHelper(positiveD, negativeD);

        return outValue;
    }

    public static void main(String[] args) 
    {
        int[] arr  = {-2, 2, -1, 0, 1};
        int[] arr1 = {-2, 2};
        int[] arr2 = {-2, 2, 10, 5, -5, 20, 1};
        int[] arr3 = {-2, 2, -1, 0, 4};
        int[] arr4 = {0, -1};

        System.out.println("Using map: ");
        Map<Integer, Integer> testMap = new HashMap<Integer, Integer>() {{
            put(1, findClosest(arr));
            put(2, findClosest(arr1));
            put(3, findClosest(arr2));
            put(4, findClosest(arr3));
            put(5, findClosest(arr4));
        }};

        testMap.forEach((k, v) -> {
            if(v != 0)
                System.out.println("closest test " + k + " : " + v);
            else
                System.out.println("closest test " + k + ": All values in array are zero");
        });

        System.out.println("\nclosest test 1 : " + findClosest(arr));
        System.out.println("closest test 2 : " + findClosest(arr1));
        System.out.println("closest test 3 : " + findClosest(arr2));
        System.out.println("closest test 4 : " + findClosest(arr3));
        System.out.println("closest test 5 : " + findClosest(arr4));

        System.out.println("\nclosest using stream test 1 : " + findClosestUsingStream(arr));
        System.out.println("closest using stream test 2 : " + findClosestUsingStream(arr1));
        System.out.println("closest using stream test 3 : " + findClosestUsingStream(arr2));
        System.out.println("closest using stream test 4 : " + findClosestUsingStream(arr3));
        System.out.println("closest using stream test 5 : " + findClosestUsingStream(arr4));

        System.out.println("\nclosest one pass test 1 : " + findClosestOnePass(arr));
        System.out.println("closest one pass test 2 : " + findClosestOnePass(arr1));
        System.out.println("closest one pass test 3 : " + findClosestOnePass(arr2));
        System.out.println("closest one pass test 4 : " + findClosestOnePass(arr3));
        System.out.println("closest one pass test 5 : " + findClosestOnePass(arr4));
    } 
}