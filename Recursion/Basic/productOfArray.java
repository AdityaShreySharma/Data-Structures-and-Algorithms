import java.util.Scanner;
public class productOfArray 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Number of Elements in the Array = ");  
    int n = obj.nextInt();
    int arr[] = new int[n];
    
    for(int i=0; i<n; i++)
    {
      System.out.print("Element " + (i+1) + " = ");
      arr[i] = obj.nextInt();
    }

    productOfArray ob = new productOfArray();
    System.out.println("Product of Array Elements = " + ob.product(arr, n));
  }
  
  public int product(int arr[], int n)
  {
    if (n <= 0)
    {
      return 1; 
    }
    return (product(arr, n-1) * arr[n-1]);
  } 
}