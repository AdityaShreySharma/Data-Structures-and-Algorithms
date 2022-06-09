public class Main
{
  public static void main(String args[])
  {
    int arr[] = {10, 5, 30, 15, 6, 1};

    HeapSort hs = new HeapSort(arr);

    hs.heapSort();
    hs.displayArray(arr);


  }
}

class HeapSort
{
  int arr[] = null;

  public HeapSort(int arr[])
  {
    this.arr = arr;
  }

  public void heapSort()
  {
    Heap h = new Heap(arr.length);
    for(int i=0; i<arr.length; i++)
    {
      h.insertNode(arr[i]);
    }

    for(int i=0; i<arr.length; i++)
    {
      arr[i] = h.extractHeadOfBinaryHeap();
    }
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

class Heap
{
  int arr[];
  int sizeOfHeap;

  public Heap(int size)
  {
    arr = new int[size + 1];
    this.sizeOfHeap = 0;
  }


  public void heapifyBottomToTop(int index)
  {
    int parent = index / 2;
    if(index <= 1)
    {
      return;
    }
    if(arr[index] < arr[parent])
    {
      int temp = arr[index];
      arr[index] = arr[parent];
      arr[parent] = temp;
    }
    heapifyBottomToTop(parent);
  }

  public void insertNode(int value)
  {
    arr[sizeOfHeap + 1] = value;
    sizeOfHeap++;
    heapifyBottomToTop(sizeOfHeap);
  }


  public void heapifyTopToBottom(int index)
  {
    int left = index * 2;
    int right = (index * 2) + 1;
    int swapChild = 0;

    if(sizeOfHeap < left)
    {
      return;
    }
    
    if(sizeOfHeap == left)
    {
      if(arr[index] > arr[left])
      {
        int temp = arr[index];
        arr[index] = arr[left];
        arr[left] = temp;
      }
      return;
    }
    else
    {
      if(arr[left] < arr[right])
      {
        swapChild = left;
      }
      else
      {
        swapChild = right;
      }
      if(arr[index] > arr[swapChild])
      {
        int temp = arr[index];
        arr[index] = arr[swapChild];
        arr[swapChild] = temp;
      }
    }
    heapifyTopToBottom(swapChild);
  }

  public int extractHeadOfBinaryHeap()
  {
    int extractedValue = arr[1];
    arr[1] = arr[sizeOfHeap];
    sizeOfHeap--;
    heapifyTopToBottom(1);
    return extractedValue;
  }
}