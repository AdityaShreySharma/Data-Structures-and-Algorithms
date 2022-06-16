public class NumberOfPathsToReachCell
{
  public static void main(String[] args) 
  {
    NumberOfPaths n = new NumberOfPaths();

    int arr[][] = { 
      { 4, 7, 1, 6 },
      { 5, 7, 3, 9 },
      { 3, 2, 1, 2 },
      { 7, 1, 6, 3 }
    };

    int cost = 25;
    int row = arr.length - 1;
    int column = arr[0].length - 1;

    System.out.println(n.numberOfPaths(arr, row, column, cost));
  }
}

class NumberOfPaths
{
  public int numberOfPaths(int arr[][], int row, int column, int cost)
  {
    if(cost < 0)
    {
      return 0;
    }
    if(row == 0 && column == 0)
    {
      return (arr[0][0] - cost == 0) ? 1 : 0;
    }
    
    if(row == 0)
    {
      return numberOfPaths(arr, 0, column - 1, cost - arr[row][column]);
    }
    if(column == 0)
    {
      return numberOfPaths(arr, row - 1, 0, cost - arr[row][column]);
    }

    int numberOfPathsFromPreviousRow = numberOfPaths(arr, row - 1, column, cost - arr[row][column]);
    int numberOfPathsFromPreviousColumn = numberOfPaths(arr, row, column - 1, cost - arr[row][column]);
  
    return numberOfPathsFromPreviousRow + numberOfPathsFromPreviousColumn;
  }
}