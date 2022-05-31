public class Main
{
  public static void main(String[] args)
  { 
    CircularDoublyLinkedList c = new CircularDoublyLinkedList();
    c.createCircularDoublyLinkedList(1);
    c.insertNode(2, 0);
    c.insertNode(3, 2);
    c.insertNode(4, 5);
    System.out.println(c.head.value);
    System.out.println(c.head.next.value);
    c.traverseCircularDoublyLinkedList();
    c.reverseTraversal();
    c.searchNode(3);
    c.deleteNode(7);
    c.traverseCircularDoublyLinkedList();
    c.deleteEntireCircularDoublyLinkedList();
    c.traverseCircularDoublyLinkedList();
  }
}

class Node
{
  int value;
  Node next;
  Node previous;
}

class CircularDoublyLinkedList
{
  Node head;
  Node tail;
  int size;

  // Create Circular Doubly Linked List
  public Node createCircularDoublyLinkedList(int nodeValue)
  {
    head = new Node();
    Node node = new Node();
    node.value = nodeValue;
    head = node;
    tail = node;
    node.next = node;
    node.previous = node;
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
      createCircularDoublyLinkedList(nodeValue);
      return;
    }

    else if(location == 0)
    {
      node.next = head;
      node.previous = tail;
      head.previous = node;
      tail.next = node;
      head = node;
    }

    else if(location >= size)
    { 
      node.next = head;
      node.previous = tail;
      head.previous = node;
      tail.next = node;
      tail = node;
    }

    else 
    {
      Node tempNode = head;
      int index = 0;
      while(index < location - 1) 
      {
        tempNode = tempNode.next;
        index++;
      }
      node.previous = tempNode;
      node.next = tempNode.next;
      tempNode.next = node;
      node.next.previous = node;
    }
    size++;
  }


  // Traversal 
  public void traverseCircularDoublyLinkedList()
  {
    if(head != null)
    { 
      Node tempNode = head;
      for(int i = 0; i < size; i++)
      { 
        System.out.print(tempNode.value);
        if(i != size - 1)
        {
          System.out.print(" -> ");
        }
        tempNode = tempNode.next;
      }
    }

    else
    { 
      System.out.println("Circular Doubly Linked List does not exist!");
    }
    System.out.println("\n");
  }


  // Reverse Traversal
  public void reverseTraversal()
  {
    if(head != null)
    { 
      Node tempNode = tail;
      for(int i=0; i<size; i++)
      {
        System.out.print(tempNode.value);  
        if(i != size - 1)
        {
          System.out.print(" <- ");
        }  
        tempNode = tempNode.previous;  
      }
      System.out.println("\n");
    }
    else
    {
      System.out.println("Circular Doubly Linked List does not exist!");
    }
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


  // Deletion
  public void deleteNode(int location)
  {
    if(head == null)
    {
      System.out.println("Circular Doubly Linked List does not exist!");
      return;
    }

    else if(location == 0)
    {
      if(size == 1)
      {
        head.previous = null;
        head.next = null;
        head = null;
        tail = null;
        size--;
        return;
      }
      else
      {
        head = head.next;
        head.previous = tail;
        tail.next = head;
        size--;
      }
    }

    else if(location >= size) 
    {
      if(size == 1)
      {
        head.previous = null;
        head.next = null;
        head = null;
        tail = null;
        size--;
        return;
      }
      else
      {
        tail = tail.previous;
        tail.next = head;
        head.previous = tail;
        size--;
      }
    }

    else
    {
      Node tempNode = head;
      for(int i = 0; i<location-1; i++)
      {
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      tempNode.next.previous = tempNode;
      size--;
    }
  }

  
  // Delete Entire Circular Doubly Linked List
  public void deleteEntireCircularDoublyLinkedList()
  {
    if(head == null)
    {
      System.out.println("Circular Doubly Linked List does not exist!");
      return;
    }

    else
    {
      Node tempNode = head;
      for(int i=0; i<size; i++)
      {
        tempNode.previous = null;
        tempNode = tempNode.next;
      }
      head = null;
      tail = null;
      System.out.println("Circular Doubly Linked List Deleted Successfully!");
    }
  }
}