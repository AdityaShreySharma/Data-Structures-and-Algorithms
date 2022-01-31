import java.util.Scanner;
public class reverseString 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("String = ");
    String str = obj.nextLine();

    reverseString ob = new reverseString();
    System.out.println("Reversed String = " + ob.reverse(str)); 
  }

  public String reverse(String str) 
  {
    if(str.isEmpty())
    {
      return str;
    }
    return reverse(str.substring(1)) + str.charAt(0); 
  }
}