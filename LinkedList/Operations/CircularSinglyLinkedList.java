public class Main
{
  public static void main(String[] args) 
  {
    CircularSinglyLinkedList c = new CircularSinglyLinkedList();
    c.createCircularSinglyLinkedList(1);
    c.insertNode(2, 0);
    c.insertNode(3, 1);
    c.insertNode(4, 8);
    // System.out.println(c.head.value);
    // System.out.println(c.head.next.value);
    c.traverseCircularSinglyLinkedList();
    c.searchNode(3);
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

  // Create Circular Singly LinkedList
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
  
}