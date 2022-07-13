public class SpiralTraverse
{
  public static void main(String[] args)
  {
    int matrix[][] = {{1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12}, 
                      {13, 14, 15, 16}};
    
    spiralTarverse(matrix);
  }

  public static void spiralTarverse(int matrix[][])
  {
    int rowStart = 0;
    int columnStart = 0;

    int rowLength = matrix.length;
    int columnLength = matrix[0].length;
    
    while(rowStart < rowLength && columnStart < columnLength)
    {
      for(int i = columnStart; i < columnLength; i++)
      {
        System.out.print(matrix[rowStart][i] + " ");
      }
      rowStart++;

      for(int i = rowStart; i < rowLength; i++)
      { 
        System.out.print(matrix[i][columnLength - 1] + " ");
      }
      columnLength--;

      if(rowStart < rowLength)
      { 
        for(int i = columnLength - 1; i >= columnStart; i--)
        { 
          System.out.print(matrix[rowLength - 1][i] + " ");
        }
        rowLength--;
      }

      if(columnStart < columnLength)
      { 
        for(int i = rowLength - 1; i >= rowStart; i--)
        {
          System.out.print(matrix[i][columnStart] + " ");
        }
        columnStart++;
      }
    }
    System.out.println(" ");
  }
}