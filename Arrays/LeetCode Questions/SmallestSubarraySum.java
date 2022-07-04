public class SmallestSubarraySum
{
  public static void main(String[] args)
  { 
    int arr[] = {1, 4, 45, 6, 0, 19};
    int value = 51;
    System.out.println(smallestSubarraySum(arr, value));
  }

  public static int smallestSubarraySum(int arr[], int value)
  {
    int currentSum = 0;
    int minLength = arr.length + 1;
    int start = 0;
    int end = 0;
    
    while(end < arr.length)
    {
      while(currentSum <= value && end < arr.length)
      {
        currentSum += arr[end++];
      }
      while(currentSum > value && start < arr.length)
      { 
        if(end - start < minLength)
        { 
          minLength = end - start;
        }
        currentSum -= arr[start++];
      }
    }
    return minLength;
  }
}