public class BinarySearch
{
  public static void main(String[] args)
  {
    BinarySearch bs = new BinarySearch();
    
    int arr[] = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25};
    bs.binarySearch(arr, 15);
  }

  public int binarySearch(int arr[], int value)
  {
    int start = 0;
    int end = arr.length - 1;
    int middle = (start + end) / 2;

    while(arr[middle] != value)
    {
      if(value < arr[middle])
      {
        end = middle - 1;
      }
      else
      {
        start = middle + 1;
      }
      middle = (start + end) / 2;
    }

    if(arr[middle] == value)
    {
      System.out.println(value + " found at index " + middle);
      return middle;
    }
    else 
    {
      System.out.println(value + " not found in the array!");
      return -1;
    }
  }
}