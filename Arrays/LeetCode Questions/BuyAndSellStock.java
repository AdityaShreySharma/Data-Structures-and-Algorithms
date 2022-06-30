public class BuyAndSellStock
{
  public static void main(String[] args)
  {
    int prices[] = {7, 1, 5, 3, 6, 4};
    System.out.println(buyAndSellStock(prices));
  }

  public static int buyAndSellStock(int prices[])
  {
    int buy = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++)
    {
      if(buy > prices[i])
      {
        buy = prices[i];
      }
      else if(prices[i] - buy > maxProfit)
      {
        maxProfit = prices[i] - buy;
      }
    }
    return maxProfit;
  }
}