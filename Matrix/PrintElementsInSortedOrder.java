import java.util.*;
public class PrintElementsInSortedOrder
{
  public static void main(String args[])
  {  
    int matrix[][] = {{10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
    
    printElementsInSortedOrder(matrix);
    System.out.println(" ");
  }

  public static void printElementsInSortedOrder(int matrix[][])
  {
    ArrayList<Integer> temp = new ArrayList<Integer>();

    for(int i = 0; i < matrix.length; i++)
    {
      for(int j = 0; j < matrix.length; j++)
      { 
        temp.add(matrix[i][j]);
      }
    }

    Collections.sort(temp);

    for(int i = 0; i < temp.size(); i++)
    { 
      System.out.print(temp.get(i) + " ");
    }
  }
}