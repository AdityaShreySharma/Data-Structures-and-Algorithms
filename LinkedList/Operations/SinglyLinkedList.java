public class Main
{
  public static void main(String[] args) 
  {
    SinglyLinkedList s = new SinglyLinkedList();
    s.createSinglyLinkedList(1);
    s.insertInLinkedList(2, 1);
    s.insertInLinkedList(3, 3);
    s.insertInLinkedList(4, 4);
    s.insertInLinkedList(5, 5);
    s.traverseLinkedList();
    s.searchNode(4);
  }
}

class Node 
{
  int value;
  Node next;
}

class SinglyLinkedList 
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
  public void insertInLinkedList(int nodeValue, int location)
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

    else if(location >= size)
    {
      node.next = null;
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
      Node nextNode = tempNode.next;
      tempNode.next = node;
      node.next = nextNode;
    }
    size++;
  }


  // LinkedList Traversal
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