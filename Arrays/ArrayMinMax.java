public class ArrayMinMax
{
  public static void main(String[] args)
  {
    int arr[] = {5, 8, 1, 3, 9, 2};
    int max = 0;
    int min = 0;
    
    if(arr[0] > arr[1])
    {  
      max = arr[0];
      min = arr[1];
    }
    else
    {
      max = arr[1];
      min = arr[0];
    }
    
    for (int i=2; i<arr.length; i++)
    {
      if(arr[i] > max)
      {
        max = arr[i];
      }
      else if(arr[i] < min)
      {
        min = arr[i];
      }
    }

    System.out.println("Max = " + max);
    System.out.println("Min = " + min);
  }
}