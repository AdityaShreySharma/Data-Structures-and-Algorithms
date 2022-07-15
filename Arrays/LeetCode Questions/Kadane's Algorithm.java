public class Kadane
{
  public static void main(String[] args)
  {
    int arr[] = {1, 2, 3, -2, 5};
    System.out.println(maximumSubarraySum(arr));
  }

  public static int maximumSubarraySum(int arr[])
  {
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for(int i=0; i<arr.length; i++) 
    {
      currentSum += arr[i];
      if(currentSum > maxSum) 
      {
        maxSum = currentSum;
      }
      if(currentSum < 0)
      {
        currentSum = 0;
      }
    }
    return maxSum;
  }
}