public class MaxProfitThroughBuyingAndSellingShareAtmostTwice
{
  public static void main(String args[])
  {
    int arr[] = {10, 22, 5, 75, 65, 80};
    System.out.println(maxProfit(arr));
  }

  public static int maxProfit(int arr[])
  {  
    int firstBuy = Integer.MIN_VALUE;
    int firstSell = 0;
    int secondBuy = Integer.MIN_VALUE;
    int secondSell = 0;

    for(int i = 0; i < arr.length; i++)
    {
      firstBuy = Math.max(firstBuy, - arr[i]);
      firstSell = Math.max(firstSell, firstBuy + arr[i]);
      secondBuy = Math.max(secondBuy, firstSell - arr[i]);
      secondSell = Math.max(secondSell, secondBuy + arr[i]);
    }
    return secondSell;
  }
}