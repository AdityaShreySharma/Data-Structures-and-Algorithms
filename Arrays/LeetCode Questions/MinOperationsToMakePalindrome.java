public class MinOperationsToMakePalindrome
{
  public static void main(String[] args)
  {  
    int arr[] = {1, 4, 5, 1};
    System.out.println(minOperationsToMakePalindrome(arr));
  }

  public static int minOperationsToMakePalindrome(int arr[])
  { 
    int count = 0;
    for(int i = 0, j = arr.length - 1; i <= j;)
    {
      if(arr[i] == arr[j])
      {
        i++; 
        j--;
      }

      else if(arr[i] > arr[j])
      {
        j--;
        arr[j] += arr[j + 1];
        count++;
      }

      else
      { 
        i++; 
        arr[i] += arr[i - 1];
        count++;
      }
    }
    return count;
  }
}