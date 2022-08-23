public class EqualSumPartition
{
  public static void main(String[] args)
  {  
    int arr[] = {3, 1, 5, 9, 12};
    int n = arr.length;

    System.out.println(equalSumPartition(arr, n));
  }

  public static boolean equalSumPartition(int arr[], int n)
  {
    int sum = 0;
    for(int i = 0; i < arr.length; i++)
    { 
      sum += arr[i];
    }

    if(sum % 2 != 0)
    { 
      return false;
    }

    boolean dp[][] = new boolean[(sum / 2) + 1][n + 1];
    
    for(int i = 0; i <= n; i++)
    {
      dp[0][i] = true;
    }
    for(int i = 1; i <= sum / 2; i++)
    {
      dp[i][0] = false;
    }

    for(int i = 1; i <= sum / 2; i++)
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

    return dp[sum / 2][n];
  }
}