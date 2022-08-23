public class CountOfSubsets
{
  public static void main(String[] args)
  {  
    int arr[] = {2, 3, 5, 6, 8, 10};
    int sum = 10;
    int n = arr.length;

    System.out.println(countOfSubsets(arr, n, sum, 0, 0));
  }

  public static int countOfSubsets(int arr[], int n, int sum, int i, int count)
  {

    if(i == n)
    {
      if(sum == 0)
      { 
        count++;
      }
      return count;
    }

    count = countOfSubsets(arr, n, sum - arr[i], i + 1, count);
    count = countOfSubsets(arr, n, sum, i + 1, count);
    return count;
  }
}