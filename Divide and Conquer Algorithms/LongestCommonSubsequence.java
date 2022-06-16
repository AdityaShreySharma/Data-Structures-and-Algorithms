public class Main 
{
  public static void main(String[] args)
  {
    LongestCommonSubsequence l = new LongestCommonSubsequence();
    String s1 = "elephant";
    String s2 = "erepat";
    int index1 = 0;
    int index2 = 0;

    System.out.println(l.longestCommonSubsequence(s1, s2, index1, index2));
  }
}

class LongestCommonSubsequence
{
  public int longestCommonSubsequence(String s1, String s2, int index1, int index2)
  {
    if(index1 == s1.length() || index2 == s2.length())
    {
      return 0;
    }
    int count1 = 0;
    if(s1.charAt(index1) == s2.charAt(index2))
    {
      count1 = 1 + longestCommonSubsequence(s1, s2, index1 + 1, index2 + 1);
    }
    int count2 = longestCommonSubsequence(s1, s2, index1, index2 + 1);
    int count3 = longestCommonSubsequence(s1, s2, index1 + 1, index2);
    return Math.max(count1, Math.max(count2, count3));
  }
}