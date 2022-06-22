import java.util.*;
public class FibonacciUsingBottomUpApproach
{
  public static void main(String args[])
  {
    System.out.println(fib(6));
  }

  public static int fib(int n)
  {
    ArrayList<Integer> results = new ArrayList<Integer>();
    results.add(0);
    results.add(1);
    for(int i=2; i<=(n-1); i++)
    {
      int n1 = results.get(i - 1);
      int n2 = results.get(i - 2);
      results.add(n1 + n2);
    }
    return results.get(n - 1);
  }
}