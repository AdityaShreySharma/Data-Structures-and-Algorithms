public class Main 
{
  public static void main(String[] args)
  {
    LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
    String str = "elrmenmet";
    int start = 0;
    int end = str.length() - 1;

    System.out.println(l.longestPalindromicSubsequence(str, start, end));
  }
}

class LongestPalindromicSubsequence
{
  public int longestPalindromicSubsequence(String str, int start, int end)
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
    if(str.charAt(start) == str.charAt(end))
    {
      count1 = 2 + longestPalindromicSubsequence(str, start + 1, end - 1);
    }
    int count2 = longestPalindromicSubsequence(str, start + 1, end);
    int count3 = longestPalindromicSubsequence(str, start, end - 1);
  
    return Math.max(count1, Math.max(count2, count3));
  }
}