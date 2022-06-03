import java.util.*;
public class StackOfPlates
{
  public static void main(String[] args)
  {
    SetOfStacks s = new SetOfStacks(3);

    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);
    System.out.println("Popped Element = " + s.pop());
    System.out.println(s.popAt(0));
    System.out.println(s.popAt(0));
  }
}

class StackNode 
{
  StackNode above;
  StackNode below;
  int value;

  public StackNode(int value)
  {
    this.value = value;
  }
}

class Stack
{
  int capacity;
  StackNode top;
  StackNode bottom;
  int size = 0;

  public Stack(int capacity)
  {
    this.capacity = capacity;
  }

  public boolean isFull()
  {
    return capacity == size;
  }

  public void join(StackNode above, StackNode below)
  {
    if(below != null) below.above = above;
    if(above != null) above.below = below;
  }

  public boolean push(int value)
  {
    if(size >= capacity) return false;
    size++;
    StackNode newNode = new StackNode(value);
    
    if(size == 1) bottom = newNode;
    join(newNode, top);
    top = newNode;
    return true;
  }

  public int pop()
  {
    if(top == null) throw new EmptyStackException();
    int result = top.value;
    top = top.below;
    size--;
    return result;
  }

  public int removeBottom()
  {
    StackNode b = bottom;
    bottom = bottom.above;
    if(bottom != null) bottom.below = null;
    size--;
    return b.value;
  }
}

class SetOfStacks
{
  ArrayList<Stack> stacks = new ArrayList<Stack>();
  int capacity;

  public SetOfStacks(int capacity)
  {
    this.capacity = capacity;
  }

  public Stack getLastStack()
  {
    if(stacks.size() == 0)
    {
      return null;
    }
    else
    {
      return stacks.get(stacks.size() - 1);
    }
  }

  public void push(int value)
  {
    Stack last = getLastStack();
    if(last != null && !last.isFull())
    {
      last.push(value);
    }
    else
    {
      Stack newStack = new Stack(capacity);
      newStack.push(value);
      stacks.add(newStack);
    }
  }

  public int pop()
  {
    Stack last = getLastStack();
    if(last == null)
    {
      throw new EmptyStackException();
    }
    else
    {
      int result = last.pop();
      if(last.size == 0)
      {
        stacks.remove(stacks.size() - 1);
      }
      return result;
    }
  }

  public int shiftLeft(int index, boolean removeTop)
  {
    Stack stack = stacks.get(index);
    int removedItem;
    if(removeTop)
    {
      removedItem = stack.pop();
    }
    else
    {
      removedItem = stack.removeBottom();
    }

    if(stack.size == 0)
    {
      stacks.remove(index);
    }
    else if(stack.size > index + 1)
    {
      int v = shiftLeft(index + 1, false);
      stack.push(v);
    }
    return removedItem;
  }

  public int popAt(int index)
  {
    return shiftLeft(index, true);
  }
}