import java.util.*;
public class FibonacciUsingTopDownApproach
{
  public static void main(String args[])
  {
    HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
    System.out.println(fib(6, h));
  }

  public static int fib(int n, HashMap<Integer, Integer> h)
  {
    if(n == 1)
    {
      return 0;
    }
    if(n == 2)
    {
      return 1;
    }
    if(!h.containsKey(n))
    {
      h.put(n, (fib(n - 1, h) + fib(n - 2, h)));
    }
    return h.get(n);
  }
}