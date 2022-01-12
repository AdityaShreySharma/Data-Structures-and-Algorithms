import java.util.Scanner;
public class Power 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Base = ");
    int base = obj.nextInt();
    System.out.print("Exponent = ");
    int exp = obj.nextInt();
    Power ob = new Power();
    System.out.println("Power = " + ob.power(base, exp));  
  }

  public int power(int base, int exp)
  {
    if(exp < 0)
    {
      return -1;
    }
    if(exp == 0)
    {
      return 1;
    }
    return base * power(base, exp-1);
  }
}
