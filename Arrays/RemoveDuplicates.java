import java.util.*;
public class RemoveDuplicates
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
    
    RemoveDuplicates ob = new RemoveDuplicates();
    System.out.println("Array without Duplicates = " + Arrays.toString(ob.removeDuplicates(arr)));
  }

  public int[] removeDuplicates(int arr[])
  {
    Arrays.sort(arr);
    int j = 0;
    for(int i=0; i<arr.length; i++) 
    {
      if(i == 0 || arr[i] != arr[i-1]) 
      {
        arr[j] = arr[i];
        j++;
      }
    }
    return Arrays.copyOf(arr, j);
  }
}