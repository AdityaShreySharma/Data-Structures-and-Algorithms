public class Partition
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
    LinkedList p = i.partition(l, 3);
    p.traverseLinkedList(); 
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

// Partition the Linked List around a value x, such that all the nodes less than x are to the left and the nodes greater than x are to the right of the Linked List
class Implementation
{
  public LinkedList partition(LinkedList l, int x)
  {
    Node currentNode = l.head;
    l.tail = l.head;
    while (currentNode != null)
    {
      Node next = currentNode.next;
      if(currentNode.value < x)
      {
        currentNode.next = l.head;
        l.head = currentNode;
      }
      else
      {
        l.tail.next = currentNode;
        l.tail = currentNode;
      }
      currentNode = next;
    }
    l.tail.next = null;
    return l;
  }
}