public class RowWithMostNumberOfOnes
{
  public static void main(String[] args)
  {
    int matrix[][] = {{0, 1, 1, 1},
                      {0, 0, 1, 1},
                      {1, 1, 1, 1},
                      {0, 0, 0, 0}};

    System.out.println(rowWithMostNumberOfOnes(matrix));
  }

  public static int rowWithMostNumberOfOnes(int matrix[][])
  {
    int rowLength = matrix.length;
    int columnLength = matrix[0].length;

    if(matrix == null || matrix.length == 0)
    {
      return 0;
    }

    int row = -1;
    int i = 0;
    int j = matrix[0].length - 1;

    while(i <= rowLength - 1 && j >= 0) 
    {
      if(matrix[i][j] == 1)
      {
        j--;
        row = i;
      }
      else
      {
        i++;
      }
    }
    return row;
  }
}