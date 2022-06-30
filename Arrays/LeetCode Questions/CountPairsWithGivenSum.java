import java.util.*;
public class CountPairsWithGivenSum
{
  public static void main(String args[])
  {
    int arr[] = {1, 1, 1, 1};
    int sum = 2;
    System.out.println(countPairsWithGivenSum(arr, sum));
  }

  public static int countPairsWithGivenSum(int arr[], int sum)
  {
    HashMap<Integer, Integer> h = new HashMap<>();
    int count = 0;
    for(int i = 0; i < arr.length; i++)
    {  
      if(h.containsKey(sum - arr[i]))
      {
        count += h.get(sum - arr[i]); 
      }
      if(h.containsKey(arr[i]))
      { 
        h.put(arr[i], h.get(arr[i]) + 1);
      }
      else
      {
        h.put(arr[i], 1);
      }
    }
    return count;
  } 
}