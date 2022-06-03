public class StackMinimum 
{
  public static void main(String[] args)
  {
    Stack s = new Stack();

    s.push(5);
    s.push(3);
    s.push(9);
    s.push(13);
    s.push(1);
    System.out.println(s.minValue());

    System.out.println("Popped Element = " + s.pop());
    System.out.println(s.minValue());
  }
}

class Stack
{
  Node top;
  Node min;

  public Stack() 
  {
    top = null;
    min = null;
  }

  public int minValue()
  {
    return min.value;
  }

  public void push(int value)
  {
    if(min == null)
    {
      min = new Node(value, min);
    }
    else if(min.value < value)
    {
      min = new Node(min.value, min);
    }
    else
    { 
      min = new Node(value, min);
    }
    top = new Node(value, top);
  }

  public int pop()
  {
    min = min.next;
    int result = top.value;
    top = top.next;
    return result;
  }
}

class Node 
{
  int value;
  Node next;

  public Node(int value, Node next)
  {
    this.value = value;
    this.next = next;
  }
}