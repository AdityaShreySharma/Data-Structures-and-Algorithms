public class Sum
{
  public static void main(String[] args)
  {
    LinkedList A = new LinkedList();
    A.insertNode(3);
    A.insertNode(1); 
    A.insertNode(5);
    A.insertNode(9);

    LinkedList B = new LinkedList();
    B.insertNode(2);
    B.insertNode(4); 
    B.insertNode(6);

    Implementation i = new Implementation();
    i.addSameNode(A, B, 7);
    i.addSameNode(A, B, 2);
    i.addSameNode(A, B, 1);

    Node intersectingNode = i.getIntersectingNode(A, B);
    System.out.println(intersectingNode.value);
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
}

// Determining whether two Linked Lists intersect and return the intersecting node
class Implementation
{
  public Node getKthNode(Node head, int k)
  {
    Node current = head;
    while(k > 0 && current != null)
    {
      current = current.next;
      k--;
    }
    return current;
  }
  public Node getIntersectingNode(LinkedList A, LinkedList B)
  {
    if(A.head == null || B.head == null)
    {
      return null;
    }
    if(A.tail != B.tail)
    {
      return null;
    }
    Node shorter = new Node();
    Node longer = new Node();
    if(A.size > B.size)
    {
      longer = A.head;
      shorter = B.head;
    }
    else
    {
      longer = B.head;
      shorter = A.head;
    }

    longer = getKthNode(longer, Math.abs(A.size - B.size));
    while(shorter != longer)
    {
      shorter = shorter.next;
      longer = longer.next;
    }
    return longer;
  }

  public void addSameNode(LinkedList A, LinkedList B, int nodeValue)
  {
    Node newNode = new Node();
    newNode.value = nodeValue;
    A.tail.next = newNode;
    A.tail = newNode;
    B.tail.next = newNode;
    B.tail = newNode;
  }
}