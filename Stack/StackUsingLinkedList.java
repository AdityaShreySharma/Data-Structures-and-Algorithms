public class StackUsingLinkedList
{
  public static void main(String[] args)
  { 
    Stack s = new Stack();

    System.out.println(s.isEmpty());
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

class Node 
{
  int value;
  Node next;
}

class Stack 
{
  LinkedList linkedList;

  public Stack()
  {
    linkedList = new LinkedList();
  }

  
  public boolean isEmpty()
  {
    if(linkedList.head == null)
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
    linkedList.insertNode(value, 0);
    System.out.println(value + " Inserted Successfully!");
  }

  
  public int pop()
  {
    int result = -1;
    if(isEmpty())
    {
      System.out.println("Stack is Empty!");
      return -1;
    }
    else
    {
      result = linkedList.head.value;
      linkedList.deleteNode(0);
    }
    return result;
  }

  
  public int peek()
  {
    int result = -1;
    if(isEmpty())
    {
      System.out.println("Stack is Empty!");
      return -1;
    }
    else
    {
      result = linkedList.head.value;
    }
    return result;
  }


  public void deleteStack()
  {
    linkedList.head = null;
    System.out.println("Stack Deleted Successfully!");
  }
}
class LinkedList
{
  Node head;
  Node tail;
  int size;

  // Create Linked List
  public Node createSinglyLinkedList(int nodeValue) 
  {
    head = new Node();
    Node node = new Node();
    node.next = null;
    node.value = nodeValue;
    head = node;
    tail = node;
    size = 1;
    return head;
  }


  // Insertion
  public void insertNode(int nodeValue, int location)
  {
    Node node = new Node();
    node.value = nodeValue;
    
    if(head == null) 
    {
      createSinglyLinkedList(nodeValue);
      return;
    }

    else if(location == 0)
    {
      node.next = head;
      head = node;
    }
    size++;
  }


  // Traversal
  public void traverseLinkedList()
  {
    
    if(head == null)
    {
      System.out.println("Linked List does not exist!");
    }
    
    else
    {
      Node tempNode = head;
      for(int i=0; i<size; i++)
      {
        System.out.print(tempNode.value);
        if(i != size - 1)
        {
          System.out.print(" -> ");
        }
        tempNode = tempNode.next;
      }
    }
    System.out.println("\n");
  }


  // Searching 
  public boolean searchNode(int nodeValue)
  {
    if(head != null)
    {
      Node tempNode = head;
      for(int i=0; i<size; i++)
      {
        if(tempNode.value == nodeValue)
        {
          System.out.println("Node found at Location - " + i);
          return true;
        }
        tempNode = tempNode.next;
      }
    }
    System.out.println("Node not found!");
    return false;
  }


  // Delete Node
  public void deleteNode(int location)
  {
    if(head == null) 
    {
      System.out.println("Linked List does not exist!");
      return;
    } 
    
    else if(location == 0)
    {
      head = head.next;
      size--;
      if(size == 0) 
      {
        tail = null;
      }
    }

    else if(location >= size)
    {
      Node tempNode = head;
      for(int i=0; i<size-1; i++)
      {
        tempNode = tempNode.next;
      }
      if(tempNode == head)
      {
        tail = head = null;
        size--;
        return;
      }
      tempNode.next = null;
      tail = tempNode;
      size--;
    }

    else
    {
      Node tempNode = head;
      for(int i=0; i<location-1; i++)
      {
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      size--;
    }
  }


  // Delete the Entire LinkedList
  public void deleteEntireLinkedList()
  {
    head = null;
    tail = null;
    System.out.println("Linked List Deleted Successfully!");
  }
}