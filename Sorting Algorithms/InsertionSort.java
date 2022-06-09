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
    for(int i=1; i<arr.length; i++)
    {
      int temp = arr[i];
      int j = i;
      while(j > 0 && arr[j-1] > temp)
      {
        arr[j] = arr[j-1];
        j--;
      }
      arr[j] = temp;
    }
  }

  public void displayArray(int arr[])
  {
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
}