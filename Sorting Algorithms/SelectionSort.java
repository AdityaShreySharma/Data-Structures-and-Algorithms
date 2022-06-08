public class SelectionSort
{
  public static void main(String args[])
  {
    SelectionSort ss = new SelectionSort();

    int arr[] = {10, 5, 30, 15, 6, 1};
    ss.selectionSort(arr);
    ss.displayArray(arr);
  }
  
  public void selectionSort(int arr[])
  {
    for(int i=0; i<arr.length; i++)
    {
      int min = i;
      for(int j=i+1; j<arr.length; j++)
      {
        if(arr[j] < arr[min])
        {
          min = j;
        }
      }
      if(min != i)
      {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
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