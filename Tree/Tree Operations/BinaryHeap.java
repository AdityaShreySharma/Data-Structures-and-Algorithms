public class BinaryHeap
{
  public static void main(String[] args) 
  {
    Heap heap = new Heap(5);

    heap.insertNode(10, "Min");
    heap.insertNode(5, "Min");
    heap.insertNode(15, "Min");
    heap.insertNode(1, "Min");
    heap.insertNode(20, "Min");
    
    System.out.println("Top Element in the Heap = " + heap.peek());

    heap.levelOrder();

    heap.extractHeadOfBinaryHeap("Min");
    heap.levelOrder();

    heap.deleteBinaryHeap();
    heap.levelOrder();
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


  public int sizeOfBinaryHeap()
  {
    return sizeOfHeap;
  }


  public void levelOrder()
  {
    for(int i=1; i<=sizeOfHeap; i++)
    {
      System.out.print(arr[i] + " ");
    }
    System.out.println(" ");
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

  public int extractHeadOfBinaryHeap(String heapType)
  {
    if(isEmpty())
    {
      return -1;
    }
    else
    {
      int extractedValue = arr[1];
      arr[1] = arr[sizeOfHeap];
      sizeOfHeap--;
      heapifyTopToBottom(1, heapType);
      return extractedValue;
    }
  }


  public void deleteBinaryHeap()
  {
    arr = null;
    System.out.println("Binary Heap Deleted!");
  }
}