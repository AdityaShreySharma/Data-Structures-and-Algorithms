public class QueueUsingArray
{
  public static void main(String[] args)
  {
    Queue q = new Queue(5);

    System.out.println(q.isEmpty());
    System.out.println(q.isFull());
    System.out.println(" ");

    q.enQueue(9);
    q.enQueue(8);
    q.enQueue(7);
    q.enQueue(6);
    q.enQueue(5);
    q.enQueue(4);
    System.out.println(" ");

    System.out.println("Dequeued Element = " + q.deQueue());
    System.out.println(" ");

    System.out.println("Top Element = " + q.peek());
    System.out.println(" ");

    q.deleteQueue();
  }
}

class Queue
{
  int arr[];
  int topOfQueue;
  int beginningOfQueue;

  public Queue(int size)
  {
    this.arr = new int[size];
    this.topOfQueue = -1;
    this.beginningOfQueue = -1;
    System.out.println("Queue Created!");
  }

  public boolean isEmpty()
  {
    if(topOfQueue == -1 || beginningOfQueue == -1)
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
    if(topOfQueue == arr.length - 1)
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
      topOfQueue++;
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
      beginningOfQueue++;
      if(beginningOfQueue > topOfQueue)
      {
        beginningOfQueue = -1;
        topOfQueue = -1;
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