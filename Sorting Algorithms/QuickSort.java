public class QuickSort
{
  public static void main(String args[])
  {
    QuickSort qs = new QuickSort();

    int arr[] = {10, 5, 30, 15, 6, 1};
    qs.quickSort(arr, 0, arr.length - 1);
    qs.displayArray(arr);
  }

  public int partition(int arr[], int start, int end)
  {
    int pivot = end;
    int i = start - 1;
    for(int j=start; j<=end; j++)
    {
      if(arr[j] <= arr[pivot])
      {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    return i;
  }

  public void quickSort(int arr[], int start, int end)
  {
    if(start < end)
    {
      int pivot = partition(arr, start, end);
      quickSort(arr, start, pivot - 1);
      quickSort(arr, pivot + 1, end);
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