public class HouseRobber
{
  public static void main(String[] args)
  {
    HouseRobber hr = new HouseRobber();

    int houseNetWorth[] = {6, 7, 1, 30, 8, 2, 4};
    System.out.println(hr.maxMoney(houseNetWorth));
  }

  public int maxMoney(int houseNetWorth[])
  {
    int dp[] = new int[houseNetWorth.length + 2];
    dp[houseNetWorth.length] = 0;
    for(int i=houseNetWorth.length - 1; i>=0; i--)
    {
      dp[i] = Math.max(houseNetWorth[i] + dp[i + 2], dp[i + 1]);
    }
    return dp[0];
  }
}