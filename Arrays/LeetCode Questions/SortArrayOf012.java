public class SortArrayOf012
{
  public static void main(String[] args)
  {
    int arr[] = {0, 2, 1, 2, 0};

    SortArrayOf012 s = new SortArrayOf012();
    
    s.sortArray(arr);
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  }

  public void sortArray(int arr[])
  {  
    int countZero = 0;
    int countOne = 0;
    int countTwo = 0;
    
    for (int i=0; i<arr.length; i++)
    {
      if(arr[i] == 0)
      {
        countZero++;
      }
      else if(arr[i] == 1)
      {
        countOne++;
      }
      else if(arr[i] == 2)
      {
        countTwo++;
      }
    }

    int i = 0;
    while(i < countZero)
    {
      arr[i] = 0;
      i++;
    }

    while(i< (countZero + countOne))
    {
      arr[i] = 1;
      i++;
    }
    while(i < (countZero + countOne + countTwo))
    {
      arr[i] = 2;
      i++;
    }
  }
}