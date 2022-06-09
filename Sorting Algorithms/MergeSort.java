public class MergeSort
{
  public static void main(String args[])
  {
    MergeSort ms = new MergeSort();

    int arr[] = {10, 5, 30, 15, 6, 1};
    ms.mergeSort(arr, 0, arr.length - 1);
    ms.displayArray(arr);
  }

  public void merge(int arr[], int left, int middle, int right)
  {
    int leftTempArray[] = new int[middle - left + 2];
    int rightTempArray[] = new int[right - middle + 1];
    for(int i=0; i<=middle-left; i++)
    {
      leftTempArray[i] = arr[left + i];
    }
    for(int i=0; i<right-middle; i++)
    {
      rightTempArray[i] = arr[middle + 1 + i];
    }

    leftTempArray[middle - left + 1] = Integer.MAX_VALUE;
    rightTempArray[right - middle] = Integer.MAX_VALUE;

    int i=0;
    int j=0;
    for(int k=left; k<=right; k++)
    {
      if(leftTempArray[i] < rightTempArray[j])
      {
        arr[k] = leftTempArray[i];
        i++;
      }
      else
      {
        arr[k] = rightTempArray[j];
        j++;
      }
    }
  }

  public void mergeSort(int arr[], int left, int right)
  {
    if(right > left)
    {
      int middle = (left + right) / 2;
      mergeSort(arr, left, middle);
      mergeSort(arr, middle+1, right);
      merge(arr, left, middle, right);
    }
  }

  public void displayArray(int arr[])
  {
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }
}