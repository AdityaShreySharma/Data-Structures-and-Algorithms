public class Main
{
  public static void main(String[] args)
  {
    ConvertOneStringToAnother c = new ConvertOneStringToAnother();
    String s1 = "table";
    String s2 = "tbres";
    
    System.out.println(c.findMinOperations(s1, s2));
  }
}

class ConvertOneStringToAnother
{
  private int findMinOperations(Integer dp[][], String s1, String s2, int index1, int index2)
  {
    if(dp[index1][index2] == null)
    {
      if(index1 == s1.length())
      {
        dp[index1][index2] = s2.length() - index2;
      }
      else if(index2 == s2.length())
      {
        dp[index1][index2] = s1.length() - index1;
      }
      else if(s1.charAt(index1) == s2.charAt(index2))
      {
        dp[index1][index2] = findMinOperations(dp, s1, s2, index1 + 1, index2 + 1);
      }
      else
      {
        int delete = findMinOperations(dp, s1, s2, index1, index2 + 1);
        int insert = findMinOperations(dp, s1, s2, index1 + 1, index2);
        int replace = findMinOperations(dp, s1, s2, index1 + 1, index2 + 1);
        dp[index1][index2] = 1 + Math.min(delete, Math.min(insert, replace));
      }
    }
    return dp[index1][index2];
  }

  public int findMinOperations(String s1, String s2)
  {
    Integer dp[][] = new Integer[s1.length() + 1][s2.length() + 1];
    return findMinOperations(dp, s1, s2, 0, 0);
  }
}