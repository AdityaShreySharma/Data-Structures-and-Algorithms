public class Main
{
  public static void main(String[] args)
  {
    NumberFactor nf = new NumberFactor();

    System.out.println(nf.waysToGetNumber(4));
    System.out.println(nf.waysToGetNumber(5));
    System.out.println(nf.waysToGetNumber(6));
  }
}

class NumberFactor
{
  private int waysToGetNumber(int dp[], int n)
  {
    if(n == 0 || n == 1 || n == 2)
    {
      return 1;
    }
    if(n == 3)
    {
      return 2;
    }
    if(dp[n] == 0)
    {
      int subProblem1 = waysToGetNumber(dp, n - 1);
      int subProblem2 = waysToGetNumber(dp, n - 3);
      int subProblem3 = waysToGetNumber(dp, n - 4);
      dp[n] = subProblem1 + subProblem2 + subProblem3;
    }
    return dp[n];
  }

  public int waysToGetNumber(int n)
  {
    int dp[] = new int[n + 1];
    return waysToGetNumber(dp, n);
  }
}