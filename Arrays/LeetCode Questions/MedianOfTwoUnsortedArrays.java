import java.util.*;
public class MedianOfTwoUnsortedArrays
{
  public static void main(String[] args)
  {
    int a[] = {-5, 3, 6, 12, 15};
    int b[] = {-12, -10, -6, -3, 4, 10};

    int mergedArray[] = new int[a.length + b.length];

    System.arraycopy(a, 0, mergedArray, 0, a.length);
    System.arraycopy(b, 0, mergedArray, a.length, b.length);
    Arrays.sort(mergedArray);

    System.out.println(medianOfTwoUnsortedArrays(mergedArray));
  }

  public static int medianOfTwoUnsortedArrays(int arr[])
  {
    int n = arr.length;

    if(n % 2 == 0)
    {  
      int i = n / 2;
      int j = arr[i];
      int k = arr[i - 1];

      int result = (j + k) / 2;
      return result;
    }

    else
    { 
      int i = Math.round(n / 2);
      return arr[i];
    }
  }
}