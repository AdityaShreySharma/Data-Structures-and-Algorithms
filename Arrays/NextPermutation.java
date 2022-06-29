public class NextPermutation
{
  public static void main(String[] args)
  {
    NextPermutation np = new NextPermutation();

    int arr[] = {1, 2, 3};
    np.nextPermutation(arr);
  }

  public void nextPermutation(int arr[])
  {
    int n = -1;
    for(int i=arr.length-1; i>0; i--)
    {
      if(arr[i] > arr[i - 1])
      {
        n = i - 1;
        break;
      }
    }

    if(n == -1)
    {
      reverse(arr, 0, arr.length - 1);
      return;
    }

    int j = arr.length - 1;
    for(int i=arr.length - 1; i>=(n+1); i--)
    {
      if(arr[i] > arr[n])
      {
        j = i;
        break;
      }
    }

    swap(arr, n, j);
    reverse(arr, j + 1, arr.length - 1);

    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }

  private void swap(int arr[], int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void reverse(int arr[], int i, int j)
  {
    while(i < j)
    {
      swap(arr, i, j);
      i++;
      j--;
    }
  }
}