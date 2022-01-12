import java.util.Scanner;
public class GCD 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("1st Number = ");
    int m = obj.nextInt();
    System.out.print("2nd Number = ");
    int n = obj.nextInt();
    GCD ob = new GCD();
    System.out.println("GCD = " + ob.gcd(m, n));
  }

  public int gcd(int m, int n)
  {
    if(m < 0 || n < 0)
    {
      return -1;
    }
    if(n == 0)
    {
      return m;
    }
    return gcd(n, m%n);
  }
}
