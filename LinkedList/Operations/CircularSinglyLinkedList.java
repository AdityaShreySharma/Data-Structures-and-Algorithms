public class Main
{
  public static void main(String[] args) 
  {
    CircularSinglyLinkedList c = new CircularSinglyLinkedList();
    c.createCircularSinglyLinkedList(1);
    c.insertNode(2, 0);
    c.insertNode(3, 1);
    c.insertNode(4, 8);
    System.out.println(c.head.value);
    System.out.println(c.head.next.value);
    c.traverseCircularSinglyLinkedList();
    c.searchNode(3);
    c.deleteNode(0);
    c.traverseCircularSinglyLinkedList();
  }
}

class Node
{
  int value;
  Node next;
}

class CircularSinglyLinkedList
{
  Node head;
  Node tail;
  int size;

  // Create Circular Singly Linked List
  public Node createCircularSinglyLinkedList(int nodeValue)
  {
    head = new Node();
    Node node = new Node();
    node.value = nodeValue;
    node.next = node;
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
      createCircularSinglyLinkedList(nodeValue);
      return;
    }

    else if(location == 0)
    {
      node.next = head;
      head = node;
      tail.next = head;
    }

    else if(location >= size)
    {
      tail.next = node;
      tail = node;
      node.next = head;
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
      Node nextNode = tempNode.next;
      tempNode.next = node;
      node.next = nextNode;
    }
    size++;
  }


  // Traversal
  public void traverseCircularSinglyLinkedList()
  {
    if(head != null)
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
      System.out.println("\n");
    } 
    else 
    {
      System.out.println("Circular Singly Linked List does not exist!");
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


  // Delete Node
  public void deleteNode(int location)
  {
    if(head == null)
    {
      System.out.println("Circular Singly Linked List does not exist!");
      return;
    }

    else if(location == 0)
    {
      head = head.next;
      tail.next = head;
      size--;
      if(size == 0)
      {
        tail = null;
        head.next = null;
        head = null;
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
        head.next = null;
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

  // Delete the Entire Circular Singly Linked List
  public void deleteEntireCircularSinglyLinkedList()
  {
    if(head == null)
    {
      System.out.println("Circular Singly Linked List does not exist!");
      return;
    }

    else
    {
      head = null;
      tail.next = null;
      tail = null;
      System.out.println("Circular Singly Linked List Deleted Successfully!")
    }
  }
}