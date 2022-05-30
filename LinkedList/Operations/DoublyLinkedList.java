public class Main
{
  public static void main(String[] args) 
  {
    DoublyLinkedList d = new DoublyLinkedList();
    d.createDoublyLinkedList(1);
    d.insertNode(2, 0);
    d.insertNode(3, 1);
    d.insertNode(4, 7);
    System.out.println(d.head.value);
    System.out.println(d.head.next.value);
    d.traverseDoublyLinkedList();
    d.reverseTraversal();
    d.searchNode(4);
    d.deleteNode(9);
    d.traverseDoublyLinkedList();
  }
}

class Node
{
  int value;
  Node next;
  Node previous;
}

class DoublyLinkedList
{
  Node head;
  Node tail;
  int size;

  // Create Doubly Linked List
  public Node createDoublyLinkedList(int nodeValue)
  {
    head = new Node();
    Node node = new Node();
    node.value = nodeValue;
    node.next = null;
    node.previous = null;
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
      createDoublyLinkedList(nodeValue);
      return;
    }

    if(location == 0)
    {
      node.next = head;
      node.previous = null;
      head.previous = node;
      head = node;
    }

    else if(location >= size)
    {
      node.next = null;
      tail.next = node;
      node.previous = tail;
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
  public void traverseDoublyLinkedList()
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
      System.out.println("Doubly Linked List does not exist!");
    }
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
      System.out.println("Doubly Linked List does not exist!");
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
      System.out.println("Doubly Linked List does not exist!");
      return;
    }

    else if(location == 0)
    {
      if(size == 1)
      {
        head = null;
        tail = null;
        size--;
        return;
      }
      else
      {
        head = head.next;
        head.previous = null;
        size--;
      }
    }

    else if(location >= size)
    {
      Node tempNode = tail.previous;
      if(size == 1)
      {
        head = null;
        tail = null;
        size--;
        return;
      }
      else
      {
        tempNode.next = null;
        tail = tempNode;
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


  // Delete Entire Doubly Linked List 
  public void deleteEntireDoublyLinkedList()
  {
    if(head == null)
    {
      System.out.println("Doubly Linked List does not exist!");
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
      System.out.println("Doubly Linked List Deleted Successfully!");
    }
  }
}