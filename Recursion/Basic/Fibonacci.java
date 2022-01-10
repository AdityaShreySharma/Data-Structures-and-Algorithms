import java.util.Scanner;
public class Fibonacci
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    int n = obj.nextInt();
    Fibonacci ob = new Fibonacci();
    System.out.println(ob.fib(n));
  }
  public int fib(int n)
  {
    if(n < 0)
    {
      return -1;
    }
    if(n == 0 || n == 1)
    {
      return 1;
    }
    return fib(n-1) + fib(n-2);
  }
}