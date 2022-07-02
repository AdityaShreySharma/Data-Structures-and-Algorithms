import java.util.*;
public class LongestCommonSubsequence
{
  public static void main(String[] args)
  {
    int arr[] = {2, 6, 1, 9, 4, 5, 3};
    System.out.println(longestCommonSubsequence(arr));
  }

  public static int longestCommonSubsequence(int arr[])
  {
    HashSet<Integer> set = new HashSet<Integer>();
    int count = 0;

    for(int i: arr)
    {
      set.add(i);
    }

    for(int i: arr)
    {
      int previousConsecutiveElement = i - 1;
      if(!set.contains(previousConsecutiveElement))
      {
        int j = i;
        while(set.contains(j))
        {  
          j++;
        }
        count = Math.max(count, j - i);
      }
    }
    return count;
  }
}