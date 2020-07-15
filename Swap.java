public class Swap 
{
    static Integer c, d;
    Integer e, f;

    public static void swap(Integer a, Integer b)
    {
        final Integer temp = Integer.valueOf(a);
        a = b;
        b = temp;

        System.out.println("In swap a: " + a + " b: " + b);
    }

    public static void testSwap()
    {
        final Integer a = Integer.valueOf(5);
        final Integer b = Integer.valueOf(10);
        c = a;
        d = b;

        swap(a, b);
        swap(c, d);

        System.out.println("In testSwap a: " + a + " b: " + b);
        System.out.println("In testSwap c: " + a + " d: " + b);
    }

    public void swapInstance()
    {
        final Integer temp = Integer.valueOf(f);
        f = e;
        e = temp;

        System.out.println("In swapInstance -----------------------------> e : " + e + " f : " + f);
    }

    public void testSwapInstance()
    {
        e = Integer.valueOf(5);
        f = Integer.valueOf(10);

        System.out.println("Before calling swapInstance -----------------> e : " + e + "  f : " + f);

        swapInstance();

        System.out.println("After calling swapInstance testSwapInstance -> e : " + e + " f : " + f);
    }

    public static void main(final String[] args) 
    {

        System.out.println("\nTest Swap: ");
        testSwap();

        System.out.println("\nTest Swap Instance: ");
        final Swap mySwap = new Swap();
        mySwap.testSwapInstance();
    }
}