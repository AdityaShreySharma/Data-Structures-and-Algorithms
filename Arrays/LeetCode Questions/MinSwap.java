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
    int swaps = 0;
    int j = 0;
    for(int i = 0; i < arr.length; i++)
    { 
      if(arr[i] > value)
      {
        j++;
      }
      else if(j > 0)
      { 
        int temp = arr[i];
        arr[i] = arr[i - j];
        arr[i - j] = temp;
        swaps++;
      }
    }
    return swaps;
  }
}