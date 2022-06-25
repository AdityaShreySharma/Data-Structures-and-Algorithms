public class LongestPalindromicSubsequence
{
  public static void main(String[] args)
  {
    LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
    String str = "elrmenmet";

    System.out.println(l.longestPalindromicSubsequence(str));
  }

  public int longestPalindromicSubsequence(String str)
  {
    int dp[][] = new int[str.length()][str.length()];
    for(int i=0; i<str.length(); i++)
    {
      for(int j=str.length()-1; j>=0; j--)
      {
        if(j > i)
        {
          dp[j][i] = 0;
        }
        else if(j == i)
        {
          dp[j][i] = 1;
        }
        else
        {
          if(str.charAt(j) == str.charAt(i))
          {
            dp[j][i] = Math.max(2 + dp[j + 1][i - 1], Math.max(dp[j][i - 1], dp[j + 1][i]));
          }
          else
          { 
            dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
          }
        }
      }
    }
    return dp[0][str.length() - 1];
  }
}