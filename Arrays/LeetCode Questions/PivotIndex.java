public class PivotIndex
{
  public static void main(String[] args)
  { 
    int arr[] = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(arr));
  }

  public static int pivotIndex(int arr[]) 
  {
    int sum = 0;
    for(int i = 0; i < arr.length; i++)
    {
      sum += arr[i];
    }
    
    int j = 0;
    for(int i = 0; i < arr.length; i++)
    {
      sum -= arr[i];
      if(j == sum)
      {
        return i;
      }
      j += arr[i];
    }
    return -1;
  }
}