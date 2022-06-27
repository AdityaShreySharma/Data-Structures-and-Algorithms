public class RotateArray
{
  public static void main(String args[])
  {
    int arr[] = {1, 2, 3, 4, 5};
    rotateArray(arr);
  }

  public static void rotateArray(int arr[])
  {
    int n = arr[arr.length - 1];
    for(int i=arr.length - 1; i>0; i--)
    {
      arr[i] = arr[i - 1];
    }
    arr[0] = n;

    for(int i=0; i<arr.length; i++) 
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
}