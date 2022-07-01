public class MaximumProductSubarray
{
  public static void main(String[] args)
  {
    int arr[] = {3, 12, 15, 23, 33, -35, 30, -40, -30, -30, -30, 26, 28};
    System.out.println(maximumProductSubarray(arr));
  }

  public static long maximumProductSubarray(int arr[])
  {
    if(arr.length == 0)
    {
      return 0;
    }

    long maxProductEndingAtCurrentIndex = arr[0];
    long minProductEndingAtCurrentIndex = arr[0];
    long maxProductSubarraySoFar = arr[0];

    for(int i = 1; i < arr.length; i++)
    {
      long temp = maxProductEndingAtCurrentIndex;
      maxProductEndingAtCurrentIndex = Math.max(arr[i], Math.max(arr[i] * maxProductEndingAtCurrentIndex, arr[i] * minProductEndingAtCurrentIndex));
      minProductEndingAtCurrentIndex = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * minProductEndingAtCurrentIndex));
      maxProductSubarraySoFar = Math.max(maxProductSubarraySoFar, maxProductEndingAtCurrentIndex);
    }
    return maxProductSubarraySoFar;
  }
}