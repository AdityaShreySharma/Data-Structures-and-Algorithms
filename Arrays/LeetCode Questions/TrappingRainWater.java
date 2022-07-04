public class TrappingRainWater
{
  public static void main(String[] args)
  { 
    int arr[] = {3, 0, 0, 2, 0, 4};
    System.out.println(trappingRainWater(arr));
  }

  public static int trappingRainWater(int arr[])
  {
    int left = 0;
    int right = arr.length - 1;
    int totalTrappedWater = 0;

    int maxLeft = arr[left];
    int maxRight = arr[right];

    while(left < right)
    {  
      if(arr[left] <= arr[right])
      {
        left++;
        maxLeft = Integer.max(maxLeft, arr[left]);
        totalTrappedWater += (maxLeft - arr[left]);
      }
      else
      {
        right--;
        maxRight = Integer.max(maxRight, arr[right]);
        totalTrappedWater += (maxRight - arr[right]);
      }
    }
    return totalTrappedWater;
  }
}