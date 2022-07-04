import java.util.*;
public class ChocolateDistributionProblem
{
  public static void main(String[] args)
  {  
    int arr[] = {3, 4, 1, 9, 56, 7, 9, 12};
    int m = 5;
    System.out.println(chocolateDistributionProblem(arr, m));
  }

  public static int chocolateDistributionProblem(int arr[], int m)
  {
    if(m == 0 || arr.length == 0)
    { 
      return 0;
    }

    Arrays.sort(arr);

    if(arr.length < m)
    {
      return -1;
    }

    int minDifference = Integer.MAX_VALUE;
    for(int i = 0; i + m - 1 < arr.length; i++)
    { 
      int diff = arr[i + m - 1] - arr[i];
      if(diff < minDifference)
      { 
        minDifference = diff;
      }
    }
    return minDifference;
  }
}