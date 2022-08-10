public class LongestPalindromicSubsequence
{
  public static void main(String args[])
  {  
    String str = "aaaabbaa";
    System.out.println(longestPalindromicSubstring(str));
  }

  public static String expand(String str, int low, int high)
  {
    while(low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high))
    {
      low--;
      high++;
    }
    return str.substring(low + 1, high);
  }
  
  public static int longestPalindromicSubstring(String str)
  {
    String maxString = "", currentString;
    int maxLength = 0, currentLength;

    for(int i = 0; i < str.length(); i++)
    {
      currentString = expand(str, i, i);
      currentLength = currentString.length();

      if(currentLength > maxLength)
      { 
        maxLength = currentLength;
        maxString = currentString;
      }

      currentString = expand(str, i, i + 1);
      currentLength = currentString.length();

      if(currentLength > maxLength)
      { 
        maxLength = currentLength;
        maxString = currentString;
      }
    }
    return maxString.length();
  }
}