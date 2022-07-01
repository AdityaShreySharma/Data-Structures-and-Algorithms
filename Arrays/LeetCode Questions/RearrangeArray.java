public class RearrangeArray
{
  public static void main(String[] args)
  {
    RearrangeArray ra = new RearrangeArray();

    int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
    ra.rearrangeArray(arr);
    ra.displayArray(arr);
  }

  public void rearrangeArray(int arr[])
  {
    int outOfPlace = -1;
    for(int i = 0; i < arr.length; i++)
    {
      if(outOfPlace >= 0)
      {
        if((arr[i] >= 0 && arr[outOfPlace] < 0) || (arr[i] < 0 && arr[outOfPlace] >= 0))
        {
          rightRotate(arr, outOfPlace, i);
          if(i - outOfPlace >= 2)
          {
            outOfPlace += 2; 
          }
          else
          { 
            outOfPlace = -1;
          }
        }
      }

      if(outOfPlace == -1)
      { 
        if((arr[i] >= 0 && (i & 0x01) == 0) || (arr[i] < 0 && (i & 0x01) == 1))
        {
          outOfPlace = i;
        }
      }
    }
  }

  public void rightRotate(int arr[], int outOfPlace, int current)
  {
    int temp = arr[current];
    for(int i = current; i > outOfPlace; i--)
    {
      arr[i] = arr[i - 1];
    }
    arr[outOfPlace] = temp;
  }

  public void displayArray(int arr[])
  {
    for(int i = 0; i < arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
}