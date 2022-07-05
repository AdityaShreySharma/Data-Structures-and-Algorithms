import java.util.*;
public class MedianOfTwoSortedArrays
{
  public static void main(String[] args)
  {
    int a[] = {1, 12, 15, 26, 38};
    int b[] = {2, 13, 17, 30, 45};
    if(a.length == b.length)
    {
      System.out.println(medianOfTwoSortedArrays(a, b));
    }
  }

  public static int medianOfTwoSortedArrays(int a[], int b[])
  {
    int n = a.length;
    int j = 0;
    int i = n - 1;

    while(a[i] > b[j] && j < n && i > -1)
    { 
      int temp = a[i];
      a[i] = b[j];
      b[j] = temp;
      i--;
      j++;
    }

    Arrays.sort(a);
    Arrays.sort(b);

    return (a[n - 1] + b[0]) / 2;
  }
}