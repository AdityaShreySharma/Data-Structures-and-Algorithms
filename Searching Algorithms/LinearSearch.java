public class LinearSearch
{
  public static void main(String[] args)
  {
    LinearSearch ls = new LinearSearch();
    
    int arr[] = {10, 5, 30, 15, 6, 1};
    ls.linearSearch(arr, 15);

  }

  public int linearSearch(int arr[], int value)
  {
    for(int i=0; i<arr.length; i++)
    {
      if(arr[i] == value)
      {
        System.out.println(value + " found at index " + i);
        return i;
      }
    }
    System.out.println(value + " not found in the array!");
    return -1;
  }
}