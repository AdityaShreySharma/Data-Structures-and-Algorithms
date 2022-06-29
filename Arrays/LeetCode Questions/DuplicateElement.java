import java.util.*;
public class DuplicateElement
{
  public static void main(String[] args)
  {
    int arr[] = {3, 1, 3, 4, 2};
    System.out.println(duplicateElement(arr));
  }

  public static int duplicateElement(int arr[])
  {
    Arrays.sort(arr);
    for(int i=0; i<arr.length - 1; i++)
    {
      if(arr[i] == arr[i+1])
      {
        return arr[i];
      }
    }
    return -1;
  }
}