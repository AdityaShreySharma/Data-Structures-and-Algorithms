public class Main
{
  public static void main(String[] args)
  { 
    HouseRobber hr = new HouseRobber();

    int houseNetWorth[] = {6, 7, 1, 30, 8, 2, 4};
    System.out.println(hr.maxMoney(houseNetWorth));
  }
}

class HouseRobber
{ 
  private int maxMoney(int dp[], int houseNetWorth[], int currentIndex)
  {
    if(currentIndex >= houseNetWorth.length)
    {
      return 0;
    }
    if(dp[currentIndex] == 0)
    {
      int stealcurrent = houseNetWorth[currentIndex] + maxMoney(dp, houseNetWorth, currentIndex + 2);
      int skipCurrent = maxMoney(dp, houseNetWorth, currentIndex + 1);
      dp[currentIndex] = Math.max(stealcurrent, skipCurrent);
    }
    return dp[currentIndex];
  }

  public int maxMoney(int houseNetWorth[])
  {
    int dp[] = new int[houseNetWorth.length];
    return maxMoney(dp, houseNetWorth, 0);
  }
}