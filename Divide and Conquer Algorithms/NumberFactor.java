public class Main
{
  public static void main(String[] args)
  {
    NumberFactor nf = new NumberFactor();
    System.out.println(nf.waysToGetNumber(4));
    System.out.println(nf.waysToGetNumber(5));
    System.out.println(nf.waysToGetNumber(6));
  }
}

class NumberFactor
{
  int waysToGetNumber(int n)
  {
    if(n == 0 || n == 1 || n == 2)
    {
      return 1;
    }
    if(n == 3)
    {
      return 2; // {1, 1, 1} {3}
    }
    int subProblem1 = waysToGetNumber(n - 1);
    int subProblem2 = waysToGetNumber(n - 3);
    int subProblem3 = waysToGetNumber(n - 4);
    
    return subProblem1 + subProblem2 + subProblem3; 
  }
}