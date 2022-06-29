import java.util.*;
public class RotateMatrix 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("Order of the Matrix = ");
    int n = obj.nextInt();
    
    int matrix[][] = new int[n][n];
    for(int i=0; i<n; i++)
    {
      for(int j=0; j<n; j++)
      {
        System.out.print("Element[" + (i+1) + "][" + (j+1) + "] = ");
        matrix[i][j] = obj.nextInt();
      }
      System.out.println();
    }
    System.out.println();

    RotateMatrix ob = new RotateMatrix();
    ob.rotateMatrix(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  public boolean rotateMatrix(int matrix[][])
  {
    if(matrix.length == 0 || matrix.length != matrix[0].length)
    {
      return false;
    }

    int n = matrix.length;
    for(int layer=0; layer<n/2; layer++)
    {
      int first = layer;
      int last = n - 1 - layer;
      
      for(int i=first; i<last; i++)
      {
        int temp = i - first;
        int top = matrix[first][i];

        matrix[first][i] = matrix[last - temp][first];
        matrix[last - temp][first] =  matrix[last][last - temp];
        matrix[last][last - temp] = matrix[i][last];
        matrix[i][last] = top;
      }
    }
    return true;
  }
}