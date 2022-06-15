import java.util.*;
public class CoinChangeProblem
{
  public static void main(String args[])
  {
    int coins[] = {1, 2, 5, 10, 20, 50, 100, 1000};
    int amount = 2035;
    System.out.println("Available Coins = " + Arrays.toString(coins));
    System.out.println("Target Amount = " + amount);

    CoinChange c = new CoinChange();
    c.coinChange(coins, amount);
  }
}

class CoinChange
{
  public void coinChange(int coins[], int n)
  {
    Arrays.sort(coins);
    int index = coins.length - 1;
    while(true)
    {
      int coinValue = coins[index];
      index--;
      int maxAmount = (n / coinValue) * coinValue;
      if(maxAmount > 0)
      {
        System.out.println("Coin Value = " + coinValue + ", Count = " + (n / coinValue));
        n = n - maxAmount;
      }
      if(n == 0)
      {
        break;
      }
    }
  }
}