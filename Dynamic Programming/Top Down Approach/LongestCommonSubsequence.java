public class Main 
{
  public static void main(String[] args)
  {
    LongestCommonSubsequence l = new LongestCommonSubsequence();
    String s1 = "elephant";
    String s2 = "erepat";

    System.out.println(l.longestCommonSubsequence(s1, s2));
  } 
}

class LongestCommonSubsequence
{
  private int longestCommonSubsequence(int dp[][], String s1, String s2, int index1, int index2)
  {
    if(index1 == s1.length() || index2 == s2.length())
    {
      return 0;
    }
    if(dp[index1][index2] == -1)
    {
      if(s1.charAt(index1) == s2.charAt(index2))
      {
        dp[index1][index2] = 1 + longestCommonSubsequence(dp, s1, s2, index1 + 1, index2 + 1);
        return dp[index1][index2];
      }
      else
      {
        int count1 = longestCommonSubsequence(dp, s1, s2, index1, index2 + 1);
        int count2 = longestCommonSubsequence(dp, s1, s2, index1 + 1, index2);
        dp[index1][index2] = Math.max(count1, count2);
      }
    }
    return dp[index1][index2];
  }

  public int longestCommonSubsequence(String s1, String s2)
  {
    int dp[][] = new int[s1.length()][s2.length()];
    for(int i=0; i<s1.length(); i++)
    {
      for(int j=0; j<s2.length(); j++)
      {
        dp[i][j] = -1;
      }
    }
    return longestCommonSubsequence(dp, s1, s2, 0, 0);
  }
}