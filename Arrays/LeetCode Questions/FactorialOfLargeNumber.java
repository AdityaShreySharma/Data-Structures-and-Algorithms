import java.math.BigInteger;
public class FactorialOfLargeNumber
{
  public static void main(String args[])
  {
    BigInteger result = factorialOfLargeNumber(100);
    System.out.println(result);
  }
     
  public static BigInteger factorialOfLargeNumber(int n)
  {
    BigInteger fac = new BigInteger("1");
    for (int i = 2; i <= n; i++)
    {
      fac = fac.multiply(BigInteger.valueOf(i));
    }
    return fac;
  }
}