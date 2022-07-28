class SpecificPair
{
  public static void main(String args[])
  {
    int matrix[][] = {
                      { 1, 2, -1, -4, -20 },
                      { -8, -3, 4, 2, 1 },
                      { 3, 8, 6, 1, 3 },
                      { -4, -1, 1, 7, -6 },
                      { 0, -4, 10, -5, 1 }
    };
    System.out.println(specificPair(matrix));
  }

  public static int specificPair(int matrix[][])
  {
    int n = matrix.length;
    int maxValue = Integer.MIN_VALUE;
    int maxArray[][] = new int[n][n];

    maxArray[n - 1][n - 1] = matrix[n - 1][n - 1];

    int max = matrix[n - 1][n - 1];
    for(int j = n - 2; j >= 0; j--)
    {
      if(matrix[n - 1][j] > max)
      {
        max = matrix[n - 1][j];
      }
      maxArray[n - 1][j] = max;
    }

    max = matrix[n - 1][n - 1];
    for(int i = n - 2; i >= 0; i--)
    { 
      if(matrix[i][n - 1] > max)
      { 
        max = matrix[i][n - 1];
      }
      maxArray[i][n - 1] = max;
    }

    for(int i = n - 2; i >= 0; i--)
    { 
      for(int j = n - 2; j >= 0; j--)
      {
        if((maxArray[i + 1][j + 1] - matrix[i][j]) > maxValue)
        {
          maxValue = maxArray[i + 1][j + 1] - matrix[i][j];
        }
        maxArray[i][j] = Math.max(matrix[i][j], Math.max(maxArray[i][j + 1], maxArray[i + 1][j]));
      }
    }
    return maxValue;
  }
}