public class EqualSumPartition
{
  public static void main(String[] args)
  {  
    int arr[] = {3, 1, 5, 9, 12};
    int n = arr.length;

    System.out.println(equalSumPartition(arr, n));
  }

  public static boolean isSubsetSum(int arr[], int n, int sum, int dp[][])
  {

    if(n == 0 && sum != 0)
    {
      return false;
    }
    if(sum == 0)
    { 
      return true;
    }

    if(arr[n - 1] > sum)
    {
      return isSubsetSum(arr, n - 1, sum, dp);
    }
    
    if(isSubsetSum(arr, n - 1, sum, dp) || isSubsetSum(arr, n - 1, sum - arr[n - 1], dp))
    { 
      return true;
    }
    return false;
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

    int dp[][] = new int[n + 1][sum + 1];
    return isSubsetSum(arr, n, sum / 2, dp);
  }
}