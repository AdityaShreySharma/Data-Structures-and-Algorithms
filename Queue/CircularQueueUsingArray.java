public class CircularQueueUsingArray 
{
  public static void main(String[] args)
  {
    CircularQueue c = new CircularQueue(5);

    System.out.println(c.isEmpty());
    System.out.println(c.isFull());
    System.out.println(" ");

    c.enQueue(9);
    c.enQueue(8);
    c.enQueue(7);
    c.enQueue(6);
    c.enQueue(5);
    c.enQueue(4);
    System.out.println(" ");

    System.out.println("Dequeued Element = " + c.deQueue());
    System.out.println(" ");

    System.out.println("Top Element = " + c.peek());
    System.out.println(" ");

    c.deleteQueue();
  }
}

class CircularQueue
{
  int arr[];
  int topOfQueue;
  int beginningOfQueue;
  int size;

  public CircularQueue(int size)
  {
    this.arr = new int[size];
    this.size = size;
    this.topOfQueue = -1;
    this.beginningOfQueue = -1;
    System.out.println("Circular Queue Created!");
  }

  public boolean isEmpty()
  {
    if(topOfQueue == -1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean isFull()
  {
    if(topOfQueue+1 == beginningOfQueue)
    {
      return true;
    }
    else if(beginningOfQueue == 0 && topOfQueue+1 == size)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public void enQueue(int value)
  {
    if(isFull())
    {
      System.out.println("Cannot insert " + value + ". Queue is Full!");
    }
    else if(isEmpty())
    { 
      beginningOfQueue = 0;
      topOfQueue++;
      arr[topOfQueue] = value;
      System.out.println(value + " Inserted Successfully!");
    }
    else
    {
      if(topOfQueue+1 == size)
      {
        topOfQueue = 0;
      }
      else
      {
        topOfQueue++;
      }
      arr[topOfQueue] = value;
      System.out.println(value + " Inserted Successfully!");
    }
  }

  public int deQueue() 
  {
    if(isEmpty())
    { 
      System.out.println("Queue is Empty!");
      return -1;
    }
    else
    {
      int result = arr[beginningOfQueue];
      arr[beginningOfQueue] = 0;
      
      if(beginningOfQueue == topOfQueue)
      {
        beginningOfQueue = -1;
        topOfQueue = -1;
      }
      else if(beginningOfQueue + 1 == size)
      { 
        beginningOfQueue = 0;
      }
      else
      {
       beginningOfQueue++;
      }
      return result;
    }
  }

  public int peek()
  {
    if(isEmpty())
    { 
      System.out.println("Queue is Empty!");
      return -1;
    }
    else
    { 
      return arr[beginningOfQueue];
    }
  }

  public void deleteQueue()
  {
    arr = null;
    System.out.println("Queue Deleted Successfully!");
  }
}