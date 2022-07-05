public class MinSwap
{
  public static void main(String[] args)
  { 
    int arr[] = {2, 7, 9, 5, 8, 7, 4};
    int value = 6;
    System.out.println(minSwap(arr, value));
  }

  public static int minSwap(int arr[], int value)
  { 
    int count = 0;

    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i] <= value)
      { 
        count++;
      }
    }

    int j = 0;
    for(int i = 0; i < count; i++)
    {
      if(arr[i] > value)
      {
        j++;
      }
    }

    int swaps = j;
    for(int i = 0, k = count; k < arr.length; i++, k++)
    { 
      if(arr[i] > value)
      {
        j--;
      }
      if(arr[k] > value)
      { 
        j++;
      }
      swaps = Math.min(swaps, j);
    }
    return swaps;
  }
}