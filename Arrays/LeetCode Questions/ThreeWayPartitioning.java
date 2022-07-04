public class ThreeWayPartitioning
{
  public static void main(String[] args)
  {  
    int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
    int a = 10;
    int b = 20;
    threeWayPartitioning(arr, a, b);
  }

  public static void threeWayPartitioning(int arr[], int a, int b)
  {
    int start = 0;
    int end = arr.length - 1;

    for(int i = 0; i <=end;)
    {
      if(arr[i] < a)
      {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        start++;
        i++;
      }
      else if(arr[i] > b)
      {
        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;
        end--;
      }
      else
      {
        i++;
      }
    }

    for(int i = 0; i < arr.length; i++)
    { 
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
}