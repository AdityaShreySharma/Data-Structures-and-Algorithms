import java.util.*;
public class MergeArraysWithoutExtraSpace
{
  public static void main(String[] args)
  {
    int a[] = {1, 3, 5, 7};
    int b[] = {0, 2, 6, 8, 9};
    mergeArraysWithoutExtraSpace(a, b);
  }

  public static void mergeArraysWithoutExtraSpace(int a[], int b[])
  {
    int n = a.length;
    int m = b.length;
    int i = 0, j = 0, k = n - 1;
    while(i <= k && j < m)
    {
      if(a[i] < b[j])
      {
        i++;
      }
      else
      {
        int temp = b[j];
        b[j] = a[k];
        a[k] = temp;
        j++;
        k--;
      }
    }
    Arrays.sort(a);
    Arrays.sort(b);

    for(int num: a)
    {
      System.out.print(num + " ");
    }
    for(int num: b)
    {
      System.out.print(num + " ");
    }
    System.out.println(" ");
  }
}