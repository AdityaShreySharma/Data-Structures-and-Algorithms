import java.util.*;
public class TripletSum
{
  public static void main(String[] args)
  { 
    int arr[] = {1, 2, 3, 4, 5};
    int sum = 9;
    tripletSum(arr, sum);
  }

  public static void tripletSum(int arr[], int sum)
  {
    Arrays.sort(arr);
    int n = arr.length;

    for(int i = 0; i < n - 3; i++)
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
