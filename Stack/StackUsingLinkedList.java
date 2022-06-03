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


class Stack 
{
  LinkedList linkedList;

  public Stack()
  {
    linkedList = new LinkedList();
    System.out.println("Stack Created!");
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
    linkedList.insertNode(value);
    System.out.println(value + " Inserted Successfully!");
  }

  
  public int pop()
  {
    int result = -1;
    if(isEmpty())
    {
      System.out.println("Stack is Empty!");
    }
    else
    {
      result = linkedList.head.value;
      linkedList.deleteNode();
    }
    return result;
  }

  
  public int peek()
  {
    int result = -1;
    if(isEmpty())
    {
      System.out.println("Stack is Empty!");
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


class Node 
{
  int value;
  Node next;
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
  public void insertNode(int nodeValue)
  {
    Node node = new Node();
    node.value = nodeValue;
    
    if(head == null) 
    {
      createSinglyLinkedList(nodeValue);
      return;
    }

    else
    {
      node.next = head;
      head = node;
    }
    size++;
  }


  // Delete Node
  public void deleteNode()
  {
    if(head == null) 
    {
      System.out.println("Linked List does not exist!");
      return;
    } 
    
    else
    {
      head = head.next;
      size--;
      if(size == 0) 
      {
        tail = null;
      }
    }
  }
}