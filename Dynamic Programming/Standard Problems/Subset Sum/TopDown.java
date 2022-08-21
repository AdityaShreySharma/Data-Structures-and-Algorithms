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
    boolean dp[][] = new boolean[n + 1][sum + 1];

    if(n == 0)
    {
      return false;
    }
    if(sum == 0)
    { 
      return true;
    }

    if(arr[n - 1] > sum)
    {
      dp[n][sum] = isSubsetSum(arr, n - 1, sum);
    }
    else
    {
      dp[n][sum] = isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    return dp[n][sum];
  }
}