import java.util.*;
public class MaxDifferenceBetweenHeights
{
  public static void main(String args[])
  {
    int arr[] = {3, 9, 12, 16, 20};
    int k = 3;
    System.out.println(maxDifferenceBetweenHeights(arr, k));
  }

  public static int maxDifferenceBetweenHeights(int arr[], int k)
  {
    Arrays.sort(arr);
    int result = arr[arr.length - 1] - arr[0];
    int min = arr[0];
    int max = arr[arr.length - 1];

    for(int i=1; i<arr.length; i++)
    {
      if((arr[i] - k) < 0)
      {
        continue;
      }
      min = Math.min(arr[0] + k, arr[i] - k);
      max = Math.max(arr[i - 1] + k, arr[arr.length - 1] - k);
      result = Math.min(result, max - min);
    }
    return result;
  }
}