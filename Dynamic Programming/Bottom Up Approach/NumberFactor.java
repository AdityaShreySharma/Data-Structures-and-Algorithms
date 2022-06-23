public class NumberFactor
{
  public static void main(String[] args)
  {
    NumberFactor nf = new NumberFactor();

    System.out.println(nf.waysToGetNumber(4));
    System.out.println(nf.waysToGetNumber(5));
    System.out.println(nf.waysToGetNumber(6));
  }

  public int waysToGetNumber(int n)
  {
    int dp[] = new int[n + 1];
    dp[0] = dp[1] = dp[2] = 1;
    dp[3] = 2;
    for (int i=4; i<=n; i++)
    {
      dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4]; 
    }
    return dp[n];
  }
}