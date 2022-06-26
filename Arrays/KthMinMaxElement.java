public class KthMinMaxElement
{
  public static void main(String[] args)
  {
    int arr[] = {12, 3, 5, 7, 4, 19, 26};

    KthMinMaxElement k = new KthMinMaxElement();

    int min = k.kthMinElement(arr, 3);
    int max = k.kthMaxElement(arr, 2);

    System.out.println("Min = " + min);
    System.out.println("Max = " + max);
  }

  public int kthMinElement(int arr[], int k)
  {
    Heap heapMin = new Heap(arr.length);
    for (int i=0; i<arr.length; i++)
    {
      heapMin.insertNode(arr[i], "Min");
    }
    for(int i=0; i<k-1; i++)
    {
      heapMin.extractHeadOfBinaryHeap("Min");
    }
    return heapMin.peek();
  }

  public int kthMaxElement(int arr[], int k)
  {
    Heap heapMax = new Heap(arr.length);
    for (int i=0; i<arr.length; i++)
    {
      heapMax.insertNode(arr[i], "Max");
    }
    for(int i=0; i<k-1; i++)
    {
      heapMax.extractHeadOfBinaryHeap("Max");
    }
    return heapMax.peek();
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


  public boolean isEmpty()
  {
    if(sizeOfHeap == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }


  public int peek() 
  {
    if(isEmpty())
    {
      System.out.println("Heap is Empty!");
      return -1;
    }
    return arr[1];
  }


  public void heapifyBottomToTop(int index, String heapType)
  {
    int parent = index / 2;
    if(index <= 1)
    {
      return;
    }
    if(heapType.equalsIgnoreCase("Min"))
    {
      if(arr[index] < arr[parent])
      {
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
      }
    }
    else if(heapType.equalsIgnoreCase("Max"))
    {
      if(arr[index] > arr[parent])
      {
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
      }
    }
    heapifyBottomToTop(parent, heapType);
  }

  public void insertNode(int value, String heapType)
  {
    arr[sizeOfHeap + 1] = value;
    sizeOfHeap++;
    heapifyBottomToTop(sizeOfHeap, heapType);
  }


  public void heapifyTopToBottom(int index, String heapType)
  {
    int left = index * 2;
    int right = (index * 2) + 1;
    int swapChild = 0;

    if(sizeOfHeap < left)
    {
      return;
    }
    if(heapType.equalsIgnoreCase("Max"))
    {
      if(sizeOfHeap == left)
      {
        if(arr[index] < arr[left])
        {
          int temp = arr[index];
          arr[index] = arr[left];
          arr[left] = temp;
        }
        return;
      }
      else
      {
        if(arr[left] > arr[right])
        {
          swapChild = left;
        }
        else
        {
          swapChild = right;
        }
        if(arr[index] < arr[swapChild])
        {
          int temp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = temp;
        }
      }
    }
    else if(heapType.equalsIgnoreCase("Min"))
    {
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
    }
    heapifyTopToBottom(swapChild, heapType);
  }

  public void extractHeadOfBinaryHeap(String heapType)
  {
    if(isEmpty())
    {
      return;
    }
    else
    {
      int extractedValue = arr[1];
      arr[1] = arr[sizeOfHeap];
      sizeOfHeap--;
      heapifyTopToBottom(1, heapType);
    }
  }
}