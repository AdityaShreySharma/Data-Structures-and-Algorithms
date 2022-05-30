public class Main
{
  public static void main(String[] args) 
  {
    DoublyLinkedList d = new DoublyLinkedList();
    d.createDoublyLinkedList(1);
    // System.out.println(d.head.value);
    d.insertNode(2, 0);
    d.insertNode(3, 1);
    d.insertNode(4, 7);
    System.out.println(d.head.value);
    System.out.println(d.head.next.value);
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
  
}