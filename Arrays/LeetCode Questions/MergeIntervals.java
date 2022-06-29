import java.util.*;
public class MergeIntervals
{
  public static void main(String[] args)
  {
    Interval arr[] = new Interval[4];
    arr[0] = new Interval(1, 3);
    arr[1] = new Interval(2, 6);
    arr[2] = new Interval(8, 10);
    arr[3] = new Interval(15, 18);

    mergeIntervals(arr);
  }

  public static void mergeIntervals(Interval arr[])
  {
    Arrays.sort(arr, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2)
      {
        if (i1.start == i2.start) 
        {
          return i1.end - i2.end;
        }
        return i1.start - i2.start;
      }
    });

    int index = 0;
    for(int i=1; i<arr.length; i++)
    {
      if(arr[index].end >= arr[i].start)
      {
        arr[index].end = Math.max(arr[index].end, arr[i].end);
      }
      else 
      {
        index++;
        arr[index] = arr[i];
      }
    }

    for(int i=0; i<=index; i++)
    {
      System.out.print("[" + arr[i].start + ", " + arr[i].end + "] ");
    }
    System.out.println(" ");
  }
}

class Interval
{
  int start, end;

  Interval(int start, int end)
  {
    this.start = start;
    this.end = end;
  }
}