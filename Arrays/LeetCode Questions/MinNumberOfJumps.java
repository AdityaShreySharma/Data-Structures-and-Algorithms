public class MinNumberOfJumps
{
  public static void main(String[] args)
  {
    int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    System.out.println(minNumberOfJumps(arr));
  }

  public static int minNumberOfJumps(int arr[])
  {
    int current = arr[0];
    int i = 0;
    int jump = 1;
    if(current == 0) 
    {
      return -1;
    }
    while (i < arr.length)
    {
      i += current;
      if(i >= arr.length - 1)
      {
        return jump;
      }
      current = arr[i];
      jump++;
    }
    return -1;
  }
}