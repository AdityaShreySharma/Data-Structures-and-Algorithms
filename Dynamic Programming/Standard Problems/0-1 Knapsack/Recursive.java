public class Knapsack
{
  public static void main(String[] args)
  {
    int weights[] = {10, 20, 30};
    int profits[] = {60, 100, 120};
    int W = 50;
    int n = weights.length;
    
    System.out.println(maxProfit(weights, profits, W, n));
  }

  public static int maxProfit(int weights[], int profits[], int W, int n)
  {
    if(n == 0 || W == 0) 
    {
      return 0;
    }

    if(weights[n - 1] <= W)
    {
      return Math.max(profits[n - 1] + maxProfit(weights, profits, W - weights[n - 1], n - 1), maxProfit(weights, profits, W, n - 1));
    }
    else
    {
      return maxProfit(weights, profits, W, n - 1);
    }
  }
}