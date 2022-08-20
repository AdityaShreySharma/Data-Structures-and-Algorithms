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
    int dp[][] = new int[n + 1][W + 1];

    for (int i = 0; i <= n; i++)
    {
      for (int j = 0; j <= W; j++)
      {
        if (i == 0 || j == 0)
        {
          dp[i][j] = 0;
        }
        else if (weights[i - 1] <= j)
        {
          dp[i][j] = Math.max(profits[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
        }
        else
        {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n][W];
  }
}