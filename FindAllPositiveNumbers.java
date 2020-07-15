import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPositiveNumbers 
{
    static int[] positiveArray;
    static int[] negativeArray;

    public static void findPositiveValues(int[] a)
    {
        List<Integer> list = new ArrayList<>();

        Arrays.stream(a)
                .forEach(v -> {
                    list.add(v);
                });

        positiveArray = new int[list.size()];
        negativeArray = new int[list.size()];

        System.out.println("list : " + list);

        // usign method reference
        positiveArray = list.stream()
                                .filter(v -> v > 0)
                                .mapToInt(Integer::intValue)
                                .sorted()
                                .toArray();

        // usign just lambda expression 
        negativeArray = list.stream()
                                .filter(v -> v < 0)
                                .mapToInt(i -> i)
                                .sorted()
                                .toArray();
    }
    
    public static void main(String[] args) 
    {
        int[] arr = {-2, 2, 10, 5, -5, 20, 1};

        System.out.println("\nFind all Positive and Negative values: ");
        findPositiveValues(arr);

        System.out.print("positive int[] : ");
        Arrays.stream(positiveArray)
                .forEach(i -> System.out.print(i + " "));

        System.out.print("\nnegative int[] : ");
        Arrays.stream(negativeArray)
                .forEach(i -> System.out.print(i + " "));
    }
}