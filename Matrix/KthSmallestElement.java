public class KthSmallestElement
{
  public static void main(String[] args)
  {
    int matrix[][] = {
                      {16, 28, 60, 64},
                      {22, 41, 63, 91},
                      {27, 50, 87, 93},
                      {36, 78, 87, 94 }
    };

    int k = 3;
    System.out.println(kthSmallestElement(matrix, k));
  }

  public static int kthSmallestElement(int matrix[][], int k)
  {
    int n = matrix.length;
        
    if(k == 0 || k > n*n || n == 0)
    {
      return -1;
    }
    
    if(k == 1)
    {
      return matrix[0][0];
    }
    
    int low = matrix[0][0];
    int high = matrix[n-1][n-1];
    
    while(low < high) 
    {
      int mid = low + (high - low) / 2;
      int count = 0;
      int j = n - 1;
    
      for (int i = 0; i < n; i++) 
      {
        while (j >= 0 && matrix[i][j] > mid)
        {
          j--;
        }  
        count += (j + 1);
      }
        
      if (count < k)
      {
        low = mid + 1;
      }
      else
      {
        high = mid;
      }
    }
    return low;
  } 
}