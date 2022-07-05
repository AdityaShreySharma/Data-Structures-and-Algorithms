import java.util.*;
public class Median
{
  public static void main(String[] args)
  {  
    int arr[] = {1, 3, 4, 2, 7, 5, 8, 6};
    System.out.println(median(arr));
  }

  public static double median(int arr[])
  {
    Arrays.sort(arr);
    int n = arr.length;

    if(n % 2 != 0)
    {
      return (double)arr[n / 2];
    }
    else
    { 
      return (double)(arr[(n - 1) / 2] + arr[n / 2]) / 2;
    }
  }
}