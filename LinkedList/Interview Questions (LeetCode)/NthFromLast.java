public class nthFromLast
{
  public static void main(String[] args)
  {
    LinkedList l = new LinkedList();
    l.createLinkedList(1);
    l.insertNode(2);
    l.insertNode(3);
    l.insertNode(2);
    l.insertNode(5);
    l.traverseLinkedList();

    Implementation i = new Implementation();
    Node n = i.nthFromLastElement(l, 5);
    System.out.println(n.value);
  }
}

class Node
{
  int value;
  Node next;
  Node previous;
}

class LinkedList 
{
  Node head;
  Node tail;
  int size;

  // Create Linked List
  public void createLinkedList(int nodeValue)
  {
    Node node = new Node();
    node.value = nodeValue;
    node.next = null;
    head = node;
    tail = node;
    size = 1;
  }

  // Insertion 
  public void insertNode(int nodeValue)
  {
    Node node = new Node();
    node.value = nodeValue;
    node.next = null;
    tail.next = node;
    tail = node;
    size++;
  }

  // Traversal
  public void traverseLinkedList()
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
}

class Implementation
{
  public Node nthFromLastElement(LinkedList l, int n)
  {
    Node pointer1 = l.head;
    Node pointer2 = l.head;
    for(int i = 0; i<n; i++)
    { 
      if(pointer2 == null)
      { 
        return null;
      }
      else
      {
        pointer2 = pointer2.next;
      }
    }

    while(pointer2 != null)
    { 
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }
    return pointer1;
  }
}