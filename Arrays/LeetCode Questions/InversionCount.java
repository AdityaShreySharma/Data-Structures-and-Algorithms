public class InversionCount
{
  public static void main(String[] args)
  {
    int arr[] = {2, 4, 1, 3, 5};
    System.out.println(countInversions(arr));
  }

  private static int merge(int arr[], int left, int middle, int right)
  {
    int i = left, j = middle, k = 0;
    int inversionCount = 0;
    int temp[] = new int[right - left + 1];
    
    while((i < middle) && (j <= right))
    {
      if(arr[i] <= arr[j])
      {
        temp[k] = arr[i];
        k++;
        i++;
      }
      else
      {
        temp[k] = arr[j];
        inversionCount += (middle - i);
        k++;
        j++;
      }
    }

    while(i < middle)
    {
      temp[k] = arr[i];
      k++;
      i++;
    }

    while(j <= right)
    {
      temp[k] = arr[j];
      k++;
      j++;
    }

    for(i = left, k = 0; i <= right; i++, k++)
    {
      arr[i] = temp[k];
    }

    return inversionCount;
  }

  private static int mergeSort(int arr[], int left, int right)
  {
    int inversionCount = 0;
    if(right > left)
    {
      int middle = (left + right) / 2;

      inversionCount = mergeSort(arr, left, middle);
      inversionCount += mergeSort(arr, middle + 1, right);
      inversionCount += merge(arr, left, middle + 1, right);
    }
    return inversionCount;
  }

  public static int countInversions(int arr[])
  {
    return mergeSort(arr, 0, arr.length - 1);
  }
}