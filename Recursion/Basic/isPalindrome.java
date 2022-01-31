import java.util.Scanner;
public class isPalindrome 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("String = ");
    String str = obj.nextLine();

    isPalindrome ob = new isPalindrome();
    boolean result = ob.palindrome(str);
    if(result) 
    {
      System.out.println("Palindrome");
    }
    else
    {
      System.out.println("Not Palindrome");
    }
  } 
  
  public boolean palindrome(String str)
  {
    String s = str.toLowerCase();
    if(s.length() == 0 || s.length() == 1)
    {
      return true; 
    }   
    if(s.charAt(0) == s.charAt(s.length()-1))
    {
      return palindrome(s.substring(1, s.length()-1));
    }
    return false;
  }
}