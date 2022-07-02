import java.util.*;
public class ArraySubset
{
  public static void main(String[] args)
  {
    int a[] = {11, 1, 13, 21, 3, 7};
    int b[] = {11, 3, 7, 1};
    System.out.println(isSubset(a, b));
  }

  public static boolean isSubset(int a[], int b[])
  {
    Set<Integer> set = new HashSet<Integer>();
    for(int i: a)
    {  
      set.add(i);
    }

    int setSize = set.size();
    for(int j: b)
    { 
      set.add(j);
    }

    if(setSize == set.size())
    { 
      return true;
    }
    else
    { 
      return false;
    }
  }
}