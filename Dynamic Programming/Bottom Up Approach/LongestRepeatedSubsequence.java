public class LongestRepeatedSubsequence
{
  public static void main(String[] args)
  {
    LongestRepeatedSubsequence l = new LongestRepeatedSubsequence();
    String str = "ATAKTKGGA";
    
    System.out.println(l.longestRepeatedSubsequence(str));
  }

  public int longestRepeatedSubsequence(String str)
  {
    int dp[][] = new int[str.length() + 1][str.length() + 1];
    for(int i=1; i<=str.length(); i++)
    {
      for(int j=1; j<=str.length(); j++)
      {
        if(str.charAt(i - 1) == str.charAt(j - 1) && i!=j)
        {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        }
        else 
        {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[str.length()][str.length()];
  }
}