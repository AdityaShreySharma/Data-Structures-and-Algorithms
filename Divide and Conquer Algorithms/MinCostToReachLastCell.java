public class MinCostToReachLastCell
{
  public static void main(String args[])
  {
    MinCost m = new MinCost();

    int cost[][] = { 
      { 4, 7, 8, 6, 4 },
      { 6, 7, 3, 9, 2 },
      { 3, 8, 1, 2, 4 },
      { 7, 1, 7, 3, 7 },
      { 2, 9, 8, 9, 3 }
    };

    int row = cost.length - 1;
    int column = cost[0].length - 1;
    System.out.println(m.minCost(cost, row, column));
  }
}

class MinCost
{
  public int minCost(int cost[][], int row, int column)
  {
    if(row == -1 || column == -1)
    {
      return Integer.MAX_VALUE;
    }
    if(row == 0 && column == 0)
    {
      return cost[0][0];
    }
    
    int minCost1 = minCost(cost, row, column - 1);
    int minCost2 = minCost(cost, row - 1, column);
    int finalMinCost = Integer.min(minCost1, minCost2);
    
    return finalMinCost + cost[row][column];
  }
}