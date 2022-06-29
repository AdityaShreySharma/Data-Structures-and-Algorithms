public class MissingNumber
{
  public static void main(String[] args) 
  {
    MissingNumber ob = new MissingNumber();
    int arr[] = {1, 2, 3, 4, 5, 6, 8, 9, 10};

    ob.missingNumber(arr);
  }

  public void missingNumber(int arr[])
  {
    // Strategy 1
    int j = 1;
    for(int i=0; i<arr.length; i++) 
    {
      if (j == arr[i]) 
      {
        j++;
      } 
      else 
      {
        System.out.println("Missing Number = " + j);
        break;
      }
    }

    // Strategy 2
    int sum1 = 0;
    int sum2 = 0;
    for(int i: arr)
    {
      sum1 += i;
    }

    int n = arr.length + 1;
    sum2 = (n*(n+1))/2;

    int diff = sum2 - sum1;
    System.out.println("Missing Number = " + diff);
  }
}