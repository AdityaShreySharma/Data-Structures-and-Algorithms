public class PalindromicArray
{
  public static void main(String[] args)
  { 
    int arr[] = {111, 222, 333, 444, 555};
    System.out.println(isPalindromicArray(arr));
  }

  public static boolean isPalindrome(int n)
  { 
    String str = "" + n;
    int len = str.length();
    for(int i = 0; i < (len / 2); i++) 
    {
      if(str.charAt(i) != str.charAt(len - 1- i))
      {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindromicArray(int arr[])
  {
    for(int i = 0; i < arr.length; i++)
    {
      if(!isPalindrome(arr[i]))
      {
        return false;
      }
    }
    return true;
  }
}