import java.util.*;
public class UnionIntersection
{
  public static void main(String[] args)
  {
    UnionIntersection ui = new UnionIntersection();
    
    int a[] = {85, 25, 1, 32, 54, 6};
    int b[] = {85, 2};
    
    ui.union(a, b);
    System.out.println(" ");
    ui.intersection(a, b);
  }

  public void union(int a[], int b[])
  {
    Set<Integer> union = new TreeSet<Integer>();

    for(int i=0; i<a.length; i++)
    {
      union.add(a[i]);
    }
    for(int i=0; i<b.length; i++)
    {
      union.add(b[i]);
    }
    System.out.print("Union = ");
    for(int i: union)
    {
      System.out.print(i + " ");
    }
    System.out.println(" ");
    System.out.println("Union Count = " + union.size());
  }

  public void intersection(int a[], int b[])
  {
    int intersectionCount = 0;
    System.out.print("Intersestion = ");
    for(int i=0; i<a.length; i++)
    {
      for(int j=0; j<b.length; j++)
      {
        if(a[i] == b[j])
        {
          System.out.print(b[j] + " ");
          intersectionCount++;
        }
      }
    }
    System.out.println(" ");
    System.out.println("Intersection Count = " + intersectionCount);
  }
}