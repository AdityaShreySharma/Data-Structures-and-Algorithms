public class CountOfSubsetsWithGivenSum
{
  static int dp[][] = new int[1001][10000];

  public static void main(String[] args)
  {
    int arr[] = {1, 2, 3, 1, 2};
    int diff = 1;

    for(int i = 0; i <1001; i++)
    {
        for(int j = 0; j <10000; j++)
        {
            dp[i][j] = -1;
        }
    }
    
    System.out.println(countSubsets(arr, arr.length, diff));
  }

  public static int countOfSubsets(int arr[], int i, int sum2, int currentSum)
  {
    if(currentSum == sum2)
    {
      return 1;
    }

    if(i >= arr.length)
    {  
      return 0;
    }

    if(dp[i][currentSum] != -1)
    { 
      return dp[i][currentSum];
    }

    if(currentSum + arr[i] > sum2)
    { 
      return dp[i][currentSum] = countOfSubsets(arr, i + 1, sum2, currentSum);
    }
    else
    { 
      return dp[i][currentSum] = countOfSubsets(arr, i + 1, sum2, currentSum + arr[i]) + countOfSubsets(arr, i + 1, sum2, currentSum);
    }
  }

  public static int countSubsets(int arr[], int n, int diff)
  {
    int sum = 0;

    for(int value : arr)
    {
      sum += value;
    }

    if(sum - diff < 0 || (sum - diff) % 2 == 1)
    {
      return 0;
    }

    return countOfSubsets(arr, 0, (sum - diff) / 2, 0);
  }
}