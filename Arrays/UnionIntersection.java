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
    HashSet<Integer> intersection1 = new HashSet<Integer>();
    for(int i: a)
    {
      intersection1.add(i);
    }
 
    HashSet<Integer> intersection2 = new HashSet<Integer>();
    for(int i: b)
    {
      if(intersection1.contains(i))
      {
        intersection2.add(i);
      }
    }
    System.out.print("Intersection = ");
    for(int i: intersection2)
    {
      System.out.print(i + " ");
    }
    System.out.println(" ");
    System.out.println("Intersection Count = " + intersection2.size());
  }
}