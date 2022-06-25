public class Main
{
  public static void main(String[] args)
  {
    LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
    String str = "elrmenmet";

    System.out.println(l.longestPalindromicSubsequence(str));
  }
}

class LongestPalindromicSubsequence
{
  private int longestPalindromicSubsequence(Integer dp[][], String str, int start, int end)
  {
    if(start > end)
    {
      return 0;
    }
    if(start == end)
    {
      return 1;
    }
    int count1 = 0;
    if(dp[start][end] == null)
    {
      if(str.charAt(start) == str.charAt(end))
      {
        count1 = 2 + longestPalindromicSubsequence(dp, str, start + 1, end - 1);
      }
      int count2 = longestPalindromicSubsequence(dp, str, start + 1, end);
      int count3 = longestPalindromicSubsequence(dp, str, start, end - 1);
      dp[start][end] = Math.max(count1, Math.max(count2, count3));
    }
    return dp[start][end];
  }

  public int longestPalindromicSubsequence(String str)
  {
    Integer dp[][] = new Integer[str.length()][str.length()];
    int start = 0;
    int end = str.length() - 1;
    return longestPalindromicSubsequence(dp, str, start, end);
  }
}