class ThreeInOne
{
  public static void main(String[] args)
  {
    Stack s = new Stack(5);

    System.out.println(s.isFull(0));
    System.out.println(s.isEmpty(0));
    System.out.println(" ");

    s.push(0, 1);
    s.push(0, 2);
    s.push(1, 4);
    s.push(1, 9);
    s.push(2, 8);
    s.push(2, 6);
    System.out.println(" ");

    System.out.println(s.pop(0));
    System.out.println(s.peek(0));
  }
}

class Stack
{
  int numberOfStacks = 3;
  int stackCapacity;
  int values[];
  int sizes[];

  public Stack(int stackSize)
  {
    this.stackCapacity = stackSize;
    values = new int[stackSize * this.numberOfStacks];
    sizes = new int[numberOfStacks];
  }

  public boolean isFull(int stackNumber)
  { 
    if(sizes[stackNumber] == stackCapacity) 
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean isEmpty(int stackNumber)
  {
    if(sizes[stackNumber] == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public int indexOfTopElement(int stackNumber)
  {
    int offset = stackNumber * stackCapacity;
    int size = sizes[stackNumber];
    return offset + size - 1;
  }

  public void push(int stackNumber, int value)
  {
    if(isFull(stackNumber))
    {
      System.out.println("Cannot Push. Stack is Full!");
    }
    else
    {
      sizes[stackNumber]++;
      values[indexOfTopElement(stackNumber)] = value;
      System.out.println(value + " Pushed Successfully!");
    }
  }

  public int pop(int stackNumber)
  {
    if(isEmpty(stackNumber))
    { 
      System.out.println("Stack is Empty");
      return -1;
    }
    else
    {
      int topIndex = indexOfTopElement(stackNumber);
      int result = values[topIndex];
      values[topIndex] = 0;
      sizes[stackNumber]--;
      return result;
    }
  }

  public int peek(int stackNumber) 
  {
    if(isEmpty(stackNumber))
    { 
      System.out.println("Stack is Empty");
      return -1;
    }
    else
    {
      int topIndex = indexOfTopElement(stackNumber);
      int result = values[topIndex];
      return result;
    }
  }
}