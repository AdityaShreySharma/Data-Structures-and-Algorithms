import java.util.*;
public class Main
{
  public static void main(String args[])
  {
    int arr[] = {9, 7, 5, 4, 2, 1, 3, 8, 6};
    BucketSort bs = new BucketSort(arr);

    bs.bucketSort();
    bs.displayArray(arr);
  }
}

@SuppressWarnings("unchecked")
class BucketSort
{
  int arr[];

  public BucketSort(int arr[])
  {
    this.arr = arr; 
  }

  public void bucketSort()
  {
    int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
    int maxValue = Integer.MIN_VALUE;
    for(int value: arr)
    {
      if(value > maxValue)
      {
        maxValue = value;
      }
    }

    ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
    for(int i=0; i<buckets.length; i++)
    {
      buckets[i] = new ArrayList<Integer>();
    }

    for(int value: arr)
    {
      int bucketNumber = (int) Math.ceil((float) value * numberOfBuckets / (float) maxValue);
      buckets[bucketNumber - 1].add(value);
    }
    
    System.out.println("Buckets before sorting :-");
    displayBuckets(buckets);

    for(ArrayList<Integer> bucket: buckets)
    {
      Collections.sort(bucket);
    }

    System.out.println("Buckets after sorting :-");
    displayBuckets(buckets);

    int index = 0;
    for(ArrayList<Integer> bucket: buckets)
    {
      for(int value: bucket)
      {
        arr[index] = value;
        index++;
      }
    }
  }

  public void displayBuckets(ArrayList<Integer>[] buckets)
  {
    for(int i=0; i<buckets.length; i++)
    {
      System.out.print("Bucket " + (i+1) + " = ");
      for(int j=0; j<buckets[i].size(); j++)
      {
        System.out.print(buckets[i].get(j) + " ");
      }
      System.out.println(" ");
    }
    System.out.println(" ");
  }

  public void displayArray(int arr[])
  {
    for(int i=0; i<arr.length; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
  } 
}