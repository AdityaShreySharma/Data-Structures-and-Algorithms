import java.util.*;
public class ZeroSumSubarray
{
  public static void main(String args[])
  {
    int arr[] = {4, 2, 0, 1, 6};
    boolean result = zeroSumSubarray(arr);
    System.out.println(result);
  }

  public static boolean zeroSumSubarray(int arr[])
  {  
    Set<Integer> set = new HashSet<Integer>();
    set.add(0);
    int sum = 0;
    for(int i: arr) 
    {
      sum += i;
      if(set.contains(sum))
      {
        return true;
      }
      set.add(sum);
    }
    return false;
  }
}