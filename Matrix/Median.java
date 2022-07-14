import java.util.*;
public class Median
{
  public static void main(String[] args)
  {  
    int matrix[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
    System.out.println(median(matrix));
  }

  public static int median(int matrix[][])
  {
    int row = matrix.length;
    int column = matrix[0].length;

    int k = 0;
    int arr[] = new int[row * column];
    for(int i = 0; i < row; i++) 
    {
      for(int j = 0; j < column; j++)
      {
        arr[k] = matrix[i][j];
        k++;
      }
    }
    Arrays.sort(arr);
    int median = k / 2;
    return arr[median];
  }
}