import java.util.Scanner;
public class SumOfDigits
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Number = ");
    int n = obj.nextInt();
    
    SumOfDigits ob = new SumOfDigits();
    System.out.println("Sum of the Digits = " + ob.sumOfDigits(n));
  }

  public int sumOfDigits(int n)
  {
    if(n < 0)
    {
      return -1;
    }
    if(n == 0) 
    {
      return 0;
    }
    return (n%10) + sumOfDigits(n/10);
  }
}