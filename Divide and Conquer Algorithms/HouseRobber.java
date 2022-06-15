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
  public int maxMoneyRecursive(int houseNetWorth[], int currentIndex)
  {
    if(currentIndex >= houseNetWorth.length)
    {
      return 0;
    }
    int stealCurrentHouse = houseNetWorth[currentIndex] + maxMoneyRecursive(houseNetWorth, currentIndex + 2);
    int skipCurrentHouse = maxMoneyRecursive(houseNetWorth, currentIndex + 1);

    return Math.max(stealCurrentHouse, skipCurrentHouse);
  }

  public int maxMoney(int houseNetWorth[]) 
  {
    return maxMoneyRecursive(houseNetWorth, 0);
  }
}