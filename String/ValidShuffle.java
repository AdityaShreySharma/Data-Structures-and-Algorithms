import java.util.*;
public class ValidShuffle
{
  public static void main(String[] args)
  {
    String first = "XY";
    String second = "12";
    String result = "1XY2";

    System.out.println(validShuffle(first, second, result));
  }

  public static boolean validShuffle(String str1, String str2, String result)
  {
    if(str1.length() + str2.length() != result.length())
    {
      return false;
    }

    str1 = sortString(str1);
    str2 = sortString(str2);
    result = sortString(result);

    int i = 0, j = 0, k = 0;
    while(k != result.length())
    { 
      if(i < str1.length() && str1.charAt(i) == result.charAt(k))
      { 
        i++;
      }
      else if(j < str2.length() && str2.charAt(j) == result.charAt(k))
      { 
        j++;
      }
      else
      { 
        return false;
      }
      k++;
    }
    if(i < str1.length() || j < str2.length())
    {
      return false;
    }
    return true;
  }

  public static String sortString(String str)
  {
    char charArray[] = str.toCharArray();
    Arrays.sort(charArray);
    str = String.valueOf(charArray);
    return str;
  }
}