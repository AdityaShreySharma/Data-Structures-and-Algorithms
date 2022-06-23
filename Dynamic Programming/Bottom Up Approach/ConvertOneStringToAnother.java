public class ConvertOneStringToAnother
{
  public static void main(String[] args)
  {
    ConvertOneStringToAnother c = new ConvertOneStringToAnother();
    String s1 = "table";
    String s2 = "tbres";
    
    System.out.println(c.findMinOperations(s1, s2));
  }

  public int findMinOperations(String s1, String s2)
  {
    int dp[][] = new int[s1.length() + 1][s2.length() + 1];

    for(int index1=0; index1<=s1.length(); index1++)
    {
      dp[index1][0] = index1;
    }

    for(int index2=0; index2<=s2.length(); index2++)
    { 
      dp[0][index2] = index2;
    }

    for(int index1=1; index1<=s1.length(); index1++)
    { 
      for(int index2=1; index2<=s2.length(); index2++)
      { 
        if(s1.charAt(index1 - 1) == s2.charAt(index2 - 1))
        { 
          dp[index1][index2] = dp[index1 - 1][index2 - 1];
        }
        else
        {
          dp[index1][index2] = 1 + Math.min(dp[index1 - 1][index2], Math.min(dp[index1][index2 - 1], dp[index1 - 1][index2 - 1]));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }
}