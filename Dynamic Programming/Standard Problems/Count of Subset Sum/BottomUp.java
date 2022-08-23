public class CountOfSubsets
{
  public static void main(String[] args)
  { 
    int arr[] = {2, 3, 5, 6, 8, 10};
    int sum = 10;
    int n = arr.length;

    System.out.println(countOfSubsets(arr, n, sum));
  }

  public static int countOfSubsets(int arr[], int n, int sum)
  { 
    int dp[][] = new int[n + 1][sum + 1];

    dp[0][0] = 1;
    for(int i = 1; i <= sum; i++)
    { 
      dp[0][i] = 0;
    }

    for(int i = 1; i <= n; i++)
    { 
      dp[i][0] = 1;
    }

    for(int i = 1; i <=n; i++)
    { 
      for(int j = 1; j <= sum; j++)
      { 
        if(arr[i - 1] > j)
        { 
          dp[i][j] = dp[i - 1][j];
        }
        else 
        {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
        }
      }
    }

    return dp[n][sum];
  }
}