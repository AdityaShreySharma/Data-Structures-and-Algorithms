import java.util.*;
public class nBykTimes
{
  public static void main(String[] args)
  {
    int arr[] = {3, 1, 2, 2, 1, 2, 3, 3};
    int k = 4;
    moreThanNByKTimes(arr, k);
  }

  public static void moreThanNByKTimes(int arr[], int k)
  {
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = arr.length;
    for(int i = 0; i < arr.length; i++)
    {
      if(!map.containsKey(arr[i]))
      {
        map.put(arr[i], 1);
      }
      else
      {
        map.put(arr[i], map.get(arr[i]) + 1);
      }
    }

    int returnArray[] = {};
    for(Map.Entry element: map.entrySet())
    {
      int temp = (int)element.getValue();

      if(temp > (n / k))
      {  
        System.out.print(element.getKey() + " ");
      }
    }
    System.out.println(" ");
  }
} 