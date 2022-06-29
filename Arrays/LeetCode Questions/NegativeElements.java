public class NegativeElements
{
  public static void main(String[] args)
  {
    int arr[] = {0, -1, 2, -3, 4, -5};
    negativeElements(arr);
  }

  public static void negativeElements(int arr[])
  {
    int j = 0, temp;
    for(int i=0; i<arr.length; i++)
    {
      if(arr[i] < 0)
      {
        if(i != j)
        {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
        j++;
      }
    }

    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
    System.out.println(" ");
  }
}