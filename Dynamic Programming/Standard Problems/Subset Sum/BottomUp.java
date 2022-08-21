public class SubsetSum
{
  public static void main(String[] args)
  {  
    int arr[] = {3, 34, 4, 12, 5, 2};
    int sum = 9;
    int n = arr.length;

    System.out.println(isSubsetSum(arr, n, sum));
  }

  public static boolean isSubsetSum(int arr[], int n, int sum)
  {
    boolean dp[][] = new boolean[sum + 1][n + 1];

    for(int i = 0; i <= n; i++)
    {
      dp[0][i] = true;
    }
    for(int i = 1; i <= sum; i++)
    {
      dp[i][0] = false;
    }

    for(int i = 1; i <= sum; i++)
    { 
      for(int j = 1; j <= n; j++)
      {
        if(arr[j - 1] > i)
        {
          dp[i][j] = dp[i][j - 1];
        }
        else
        {
          dp[i][j] = dp[i][j - 1] || dp[i - arr[j - 1]][j - 1];
        }
      }
    }
    
    return dp[sum][n];
  }
}