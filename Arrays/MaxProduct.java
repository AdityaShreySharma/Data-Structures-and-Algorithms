import java.util.*;
public class MaxProduct
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Number of Elements = ");
    int n = obj.nextInt();

    int arr[] = new int[n];
    for(int i=0; i<n; i++)
    {
      System.out.print("Element " + (i+1) + " = ");
      arr[i] = obj.nextInt();
    }
    System.out.println();

    MaxProduct ob = new MaxProduct();
    System.out.println("Two Integers that yield the Maximum Product in the Array = " + ob.maxProduct(arr));
  }

  public String maxProduct(int arr[]) 
  {
    int max = 0;
    String pairs = "";
    String iToString;
    String jToString;
    for(int i=0; i<arr.length; i++)
    {
      for(int j=i+1; j<arr.length; j++)
      {
        if((arr[i] * arr[j]) > max)
        {
          max = arr[i] * arr[j];
          iToString = Integer.toString(arr[i]);
          jToString = Integer.toString(arr[j]);
          pairs = iToString + ", " + jToString;
        }
      }
    }
    return pairs;
  }
}
