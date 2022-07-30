public class Rotation
{
  public static void main(String[] args)
  { 
    String str1 = "abcde";
    String str2 = "cdeab";
    System.out.println(isRotation(str1, str2));
  }

  public static boolean isRotation(String str1, String str2)
  { 
    if(str1.length() != str2.length() || str1.length() <= 2)
    { 
      return false;
    }
    return ((str1 + str1).indexOf(str2) != -1);
  }
}