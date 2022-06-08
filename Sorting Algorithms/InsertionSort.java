public class InsertionSort
{
  public static void main(String args[])
  {
    InsertionSort is = new InsertionSort();

    int arr[] = {10, 5, 30, 15, 6, 1};
    is.insertionSort(arr);
    is.displayArray(arr);
  }
  public void insertionSort(int arr[])
  {
    
  }

  public void displayArray(int arr[])
  {
    int n = arr.length;
    for(int i=0; i<n; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
}