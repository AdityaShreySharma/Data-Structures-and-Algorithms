import java.util.*;
public class DuplicateCharacters
{
  public static void main(String[] args)
  {
    String str = "Data Structures and Algorithms";
    String s = "";
    for(int i = 0; i < str.length(); i++)
    {
      s += Character.toLowerCase(str.charAt(i));
    }
    duplicateCharacters(s);
  }

  public static void duplicateCharacters(String str)
  { 
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < str.length(); i++)
    {
      if(!map.containsKey(str.charAt(i)))
      {
        map.put(str.charAt(i), 1);
      }
      else
      {
        map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
      }
    }

    map.remove(' ');

    for(Map.Entry element : map.entrySet())
    {
      char key = (char)element.getKey();
      int value = ((int)element.getValue());

      if(value > 1)
      {
        System.out.println("Character = " + key + ", Count = " + value);
      }
    }
  }
}