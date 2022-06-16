public class Main
{
  public static void main(String[] args)
  {
    ConvertOneStringToAnother c = new ConvertOneStringToAnother();
    System.out.println(c.findMinOperations("table", "tbres", 0, 0));
  }
}

class ConvertOneStringToAnother
{
  public int findMinOperations(String s1, String s2, int index1, int index2)
  {
    if(index1 == s1.length())
    {
      return s2.length() - index2;
    }
    if(index2 == s2.length())
    {
      return s1.length() - index1;
    }
    if(s1.charAt(index1) == s2.charAt(index2))
    {
      return findMinOperations(s1, s2, index1 + 1, index2 + 1);
    }

    int delete = 1 + findMinOperations(s1, s2, index1, index2 + 1);
    int insert = 1 + findMinOperations(s1, s2, index1 + 1, index2);
    int replace = 1 + findMinOperations(s1, s2, index1 + 1, index2 + 1);

    return Math.min(delete, Math.min(insert, replace));
  }
}