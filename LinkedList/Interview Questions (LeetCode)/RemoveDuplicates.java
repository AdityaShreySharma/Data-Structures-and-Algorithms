import java.util.*;
public class RemoveDuplicates
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
    i.deleteDuplicates(l);
    l.traverseLinkedList();
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

@SuppressWarnings("unchecked")
class Implementation
{
  public void deleteDuplicates(LinkedList l)
  {
    HashSet<Integer> h = new HashSet();
    Node current = l.head;
    Node previous = null;
    while (current != null)
    {
      int currentValue = current.value;
      if(h.contains(currentValue))
      {
        previous.next = current.next;
        l.size--;
      }
      
      else
      {
        h.add(currentValue);
        previous = current;
      }
      current = current.next;
    }
  }
}