import java.util.Scanner;
public class Factorial
{
  public static void main(String args[])
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Number = ");
    int n = obj.nextInt();
    
    Factorial ob = new Factorial();
    System.out.println("Factorial = " + ob.fac(n));
  }

  public int fac(int n)
  {
    if(n < 0)
    {
      return -1;
    }
    if(n == 0 || n == 1)
    {
      return 1;
    }
    return n * fac(n-1);
  }
}