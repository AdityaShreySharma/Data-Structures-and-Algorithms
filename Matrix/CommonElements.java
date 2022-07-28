import java.util.*;
public class CommonElements
{
  public static void main(String [] args)
  {  
    int matrix[][] = { 
        {1, 2, 1, 4, 8},
        {3, 7, 8, 5, 1},
        {8, 7, 7, 3, 1},
        {8, 1, 2, 7, 9}
    };

    commonElements(matrix);
  }

  public static void commonElements(int matrix[][])
  {
    Map<Integer, Integer> map = new HashMap<>();

    for(int j = 0; j < matrix[0].length; j++)
    { 
      map.put(matrix[0][j], 1);
    }

    for(int i = 0; i < matrix.length; i++)
    {
      for(int j = 0; j < matrix[0].length; j++)
      { 
        if(map.get(matrix[i][j]) != null && map.get(matrix[i][j]) == i)
        {
          map.put(matrix[i][j], i + 1);
          if(i == matrix.length - 1)
          {
            System.out.print(matrix[i][j] + " ");
          }
        }
      }
    }
  }
}