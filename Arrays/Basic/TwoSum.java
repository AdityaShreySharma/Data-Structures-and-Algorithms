import java.util.*;
public class TwoSum
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

    System.out.print("Target = ");
    int target = obj.nextInt();
    System.out.println();

    TwoSum ob = new TwoSum();
    System.out.println("Pairs = " + Arrays.toString(ob.twoSum(arr, target)));
  }

  public int[] twoSum(int arr[], int target)
  {
    for(int i=0; i<arr.length; i++)
    {
      for(int j=i+1; j<arr.length; j++)
      {
        if(arr[i] + arr[j] == target)
        {
          return new int[] {i, j};
        }
      }
    }
    throw new IllegalArgumentException("No Pairs Found!");
  }
}