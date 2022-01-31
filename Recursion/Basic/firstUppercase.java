import java.util.Scanner;
public class firstUppercase 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("String = ");
    String str = obj.nextLine();

    firstUppercase ob = new firstUppercase();
    System.out.println("First Uppercase Character = " + ob.first(str));  
  }

  public static char first(String str) 
  {
    if(str.isEmpty()) 
    {
      return ' ';
    }
    if(Character.isUpperCase(str.charAt(0))) 
    {
      return str.charAt(0);
    }
    return first(str.substring(1));
  }
}