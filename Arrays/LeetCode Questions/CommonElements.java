import java.util.*;
public class CommonElements
{
  public static void main(String[] args) 
  {
    CommonElements ce = new CommonElements();
    
    int a[] = {1, 5, 10, 20, 40, 80};
    int b[] = {6, 7, 20, 80, 100};
    int c[] = {3, 4, 15, 20, 30, 70, 80, 120};

    System.out.println(ce.commonElements(a, b, c));
  }

  public ArrayList<Integer> commonElements(int a[], int b[], int c[])
  {
    Set<Integer> A = new TreeSet<Integer>();
    Set<Integer> B = new TreeSet<Integer>();
    Set<Integer> C = new TreeSet<Integer>();

    for(int i: a)
    {
      A.add(i);
    }

    for(int j: b)
    {
      if(A.contains(j))
      {
        B.add(j);
      }
    }

    for(int k: c)
    { 
      if(B.contains(k))
      {
        C.add(k);
      }
    }

    ArrayList<Integer> common = new ArrayList<>(C);
    return common;
  }
}