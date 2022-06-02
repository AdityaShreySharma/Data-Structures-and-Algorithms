public class Sum
{
  public static void main(String[] args)
  {
    LinkedList A = new LinkedList();
    A.insertNode(7);
    A.insertNode(1); 
    A.insertNode(6);
    A.traverseLinkedList();

    LinkedList B = new LinkedList();
    B.insertNode(5);
    B.insertNode(9); 
    B.insertNode(2);
    B.traverseLinkedList();

    Implementation i = new Implementation();
    LinkedList result = i.sumLinkedLists(A, B);
    result.traverseLinkedList();
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
    if(head == null)
    {
      createLinkedList(nodeValue);
      return;
    }
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
        System.out.print(" <- ");
      }
      tempNode = tempNode.next;
    }
    System.out.println("\n");
  }
}

// Add two numbers whose digits are stored as nodes of separate Linked Lists in reverse order and return the sum as a reversed Linked List
class Implementation
{
  public LinkedList sumLinkedLists(LinkedList A, LinkedList B)
  {
    Node node1 = A.head;
    Node node2 = B.head;
    int carry = 0;
    LinkedList result = new LinkedList();
    while(node1 != null || node2 != null)
    {
      int res = carry;
      if(node1 != null)
      {
        res += node1.value;
        node1 = node1.next;
      }
      if(node2 != null)
      {
        res += node2.value;
        node2 = node2.next;
      }
      result.insertNode(res % 10);
      carry = res / 10;
    }
    return result;
  }
}