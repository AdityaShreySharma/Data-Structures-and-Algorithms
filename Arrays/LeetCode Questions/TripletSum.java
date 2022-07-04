import java.util.*;
public class TripletSum
{
  public static void main(String[] args)
  { 
    int arr[] = {1, 2, 4, 3, 6};
    int sum = 10;
    tripletSum(arr, sum);
  }

  public static void tripletSum(int arr[], int sum)
  {
    Arrays.sort(arr);
    for(int i = 0; i < arr.length; i++)
    { 
      int k = sum - arr[i];
      int low = i + 1;
      int high = arr.length - 1;
      while(low < high)
      {
        if(arr[low] + arr[high] < k)
        {
          low++;
        }
        else if(arr[low] + arr[high] > k)
        {
          high--;
        }
        else
        { 
          System.out.println("(" + arr[i] + ", " + arr[low] + ", " + arr[high] + ")");
          low++;
          high--;
        }
      }
    }
  }
}