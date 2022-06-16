public class ZeroOneKnapsackProblem
{
  public static void main(String[] args)
  {
    ZeroOneKnapsack z = new ZeroOneKnapsack();

    int profits[] = {31, 26, 17, 72};
    int weights[] = {3, 1, 2, 5};
    int capacity = 7;
    int currentIndex = 0;
    System.out.println(z.knapsack(profits, weights, capacity, currentIndex));
  }
}

class ZeroOneKnapsack
{
  public int knapsack(int profits[], int weights[], int capacity, int currentIndex)
  {
    if(capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length)
    {
      return 0;
    }

    int profit1 = 0;
    if(weights[currentIndex] <= capacity)
    {
      profit1 = profits[currentIndex] + knapsack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
    }
    int profit2 = knapsack(profits, weights, capacity, currentIndex + 1);
    return Math.max(profit1, profit2);
  }
}