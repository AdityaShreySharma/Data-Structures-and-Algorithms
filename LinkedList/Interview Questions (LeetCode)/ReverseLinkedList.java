public class ReverseLinkedList
{
  public static void main(String[] args)
  {
    LinkedList l = new LinkedList();
    l.createLinkedList(1);
    l.insertNode(9);
    l.insertNode(5);
    l.insertNode(13);
    l.insertNode(2);
    l.traverseLinkedList();

    Implementation i = new Implementation();
    LinkedList r = i.reverseLinkedList(l);
    r.traverseLinkedList(); 
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
  public LinkedList reverseLinkedList(LinkedList l)
  {
    Node previous = null;
    Node current = l.head;
    Node next = null;
    while (current != null) 
    {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    l.head = previous;
    return l;
  }
}