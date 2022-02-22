import java.util.*;
public class ReverseArray 
{
  public static void main(String args[])
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

    ReverseArray ob = new ReverseArray();
    ob.reverse(arr);
  }  

  public void reverse(int arr[])
  {
    for(int i=0; i<arr.length/2; i++)
    {
      int j = arr.length - i - 1;
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    System.out.println("Reversed Array = " + Arrays.toString(arr));
  }
}
