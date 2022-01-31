import java.util.Scanner;
public class capitalizeWord 
{
  public static void main(String[] args) 
  {
    Scanner obj = new Scanner(System.in);
    System.out.print("String = ");
    String str = obj.nextLine();

    capitalizeWord ob = new capitalizeWord();
    System.out.println("Capitalized Word String = " + ob.capital(str));
  }
  
  public static String capital(String str) 
  {
    if(str.isEmpty()) 
    {
      return str;
    }
    char ch = str.charAt(str.length()-1);
    if(str.length() == 1) 
    {
      return Character.toString(Character.toUpperCase(ch));
    }
    if((str.substring(str.length()-2, str.length()-1).equals(" "))) 
    {
      ch = Character.toUpperCase(ch);
    }
    return capital(str.substring(0,str.length()-1)) + Character.toString(ch);
  }
}