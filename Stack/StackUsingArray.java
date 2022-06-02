public class StackUsingArray
{
  public static void main(String args [])
  {
    Stack s = new Stack(5);
    
    boolean stackIsEmpty = s.isEmpty();
    System.out.println(stackIsEmpty);
    System.out.println(" ");

    boolean stackIsFull = s.isFull();
    System.out.println(stackIsFull);
    System.out.println(" ");

    s.push(1);
    s.push(3);
    s.push(2);
    s.push(4);
    s.push(9);
    s.push(5);
    System.out.println(s.isEmpty());
    System.out.println(" ");

    System.out.println("Popped Element = " + s.pop());
    System.out.println(" ");

    System.out.println("Top Element = " + s.peek());
    System.out.println(" ");

    s.deleteStack();
  }
}

class Stack
{
  int arr[];
  int topOfStack;

  public Stack(int size)
  {
    this.arr = new int[size];
    this.topOfStack = -1;
    System.out.println("Stack Created!");
  }

  public boolean isEmpty()
  {
    if(topOfStack == -1)
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
    if(topOfStack == arr.length - 1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public void push(int value)
  {
    if(isFull())
    {
      System.out.println("Cannot Push " + value + ". Stack is Full!");
    }
    else
    {
      arr[topOfStack + 1] = value;
      topOfStack++;
      System.out.println(value + " Inserted Successfully!");
    }
  }

  public int pop()
  {
    if(isEmpty())
    { 
      System.out.println("Stack is Empty");
      return -1;
    }
    else
    {
      int topElement = arr[topOfStack];
      topOfStack--;
      return topElement;
    }
  }

  public int peek()
  {
    if(isEmpty())
    { 
      System.out.println("Stack is Empty");
      return -1;
    }
    else
    {
      return arr[topOfStack];
    }
  }

  public void deleteStack()
  {
    arr = null;
    System.out.println("Stack Deleted Successfully!");
  }
}