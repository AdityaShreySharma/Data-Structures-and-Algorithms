public class CountAndSay
{
  public static void main(String[] args)
  {
    int n = 4;
    System.out.println(countAndSay(n));
  }

  public static String Count(String str)
  {  
    int count = 1;
    char ch = str.charAt(0);
    StringBuilder current = new StringBuilder();
    for(int i = 1; i < str.length(); i++)
    {
      if(str.charAt(i) == ch)
      {
        count++;
      }
      else 
      {
        current.append(count);
        current.append(ch);
        ch = str.charAt(i);
        count = 1;
      }
    }
    current.append(count);
    current.append(ch);
    return current.toString();
  }

  public static String countAndSay(int n)
  {
    String str = "1";
    for(int i = 1; i < n; i++)
    {
      str = Count(str);
    }
    return str;
  }
}