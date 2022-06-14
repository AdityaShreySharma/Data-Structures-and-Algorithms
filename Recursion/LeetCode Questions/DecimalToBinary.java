import java.util.Scanner;
public class DecimalToBinary
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Number = ");
    int n = obj.nextInt();
    
    DecimalToBinary ob = new DecimalToBinary();
    System.out.println("Binary Equivalent = " + ob.decimalToBinary(n));
  }

  public int decimalToBinary(int n)
  {
    if(n == 0)
    {
      return 0;
    }
    return (n%2) + (10 * decimalToBinary(n/2));
  }
}