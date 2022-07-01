public class RearrangeArray
{
  public static void main(String[] args)
  {
    int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
    rearrangeArray(arr);
  }

  public static int partitionArray(int arr[])
  {
    int j = 0;
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i] < 0)
      {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }
    return j;
  }

  public static void rearrangeArray(int arr[])
  {
    int partition = partitionArray(arr);
    for(int i = 0; (partition < arr.length && i < partition); partition++, i += 2)
    {
      int temp = arr[i];
      arr[i] = arr[partition];
      arr[partition] = temp;
    }

    for(int i = 0; i < arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
} 