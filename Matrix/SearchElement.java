public class SearchElement
{
  public static void main(String[] args)
  {  
    int matrix[][] = {{1, 3, 5, 7},
                      {10, 11, 16, 20},
                      {23, 30, 34, 60}};
    
    int target = 3;

    System.out.println(searchElement(matrix, target));
  }

  public static boolean searchElement(int matrix[][], int target)
  {
    if(matrix.length == 0 || matrix[0].length == 0)
    {
      return false;
    }

    int row = matrix.length;
    int column = matrix[0].length;
    int start = 0;
    int end = (row * column) - 1;

    while(start <= end) 
    {
      int mid = (start + end) / 2;
      int i = mid / column;
      int j = mid % column;

      if(matrix[i][j] == target)
      {
        return true;
      }
      
      if(matrix[i][j] < target)
      { 
        start = mid + 1;
      }
      else
      {
        end = mid - 1;
      }
    }
    return false;
  }
}