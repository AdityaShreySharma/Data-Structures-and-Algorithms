import java.util.*;
public class QueueUsingStacks
{
  public static void main(String[] args)
  {
    QueueStack q = new QueueStack();

    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);
    System.out.println("Popped Element = " + q.deQueue());
    System.out.println("Top Element = " + q.peek());
    q.enQueue(6);
    System.out.println("Popped Element = " + q.deQueue());
    System.out.println("Top Element = " + q.peek());
  }
}

class QueueStack
{
  Stack<Integer> s1;
  Stack<Integer> s2;

  public QueueStack()
  {
    s1 = new Stack<Integer>();
    s2 = new Stack<Integer>();
  }

  public int queueSize()
  {
    return s1.size() + s2.size();
  }

  public void enQueue(int value)
  {
    s1.push(value);
  }

  public void shiftStacks()
  {
    if(s2.isEmpty()) 
    {
      while(!s1.isEmpty())
      {
        int poppedElement = s1.pop();
        s2.push(poppedElement);
      }
    }
  }

  public int deQueue()
  {
    shiftStacks();
    return s2.pop();
  }

  public int peek()
  {
    shiftStacks();
    return s2.peek();
  }
}