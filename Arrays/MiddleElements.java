import java.util.*;
public class MiddleElements 
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
    
    MiddleElements ob = new MiddleElements();
    System.out.println("Array without First and Last Elements = " + Arrays.toString(ob.middleElements(arr)));
  }

  static int[] middleElements(int arr[])
  {
    return Arrays.copyOfRange(arr, 1, arr.length-1);
  }  
}
