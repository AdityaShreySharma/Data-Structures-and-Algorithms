public class QueueUsingLinkedList
{
  public static void main(String[] args)
  {
    Queue q = new Queue();

    System.out.println(q.isEmpty());
    System.out.println(" ");

    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);
    System.out.println(" ");

    System.out.println("Dequeued Element = " + q.deQueue());
    System.out.println(" ");

    System.out.println("Top Element = " + q.peek());
    System.out.println(" ");

    q.deleteQueue();
  }
}


class Queue
{
  LinkedList linkedList;

  public Queue()
  {
    linkedList = new LinkedList();
    System.out.println("Queue Created!");
  }


  public boolean isEmpty()
  {
    if(linkedList.head == null)
    {
      return true;
    }
    else
    {
      return false;
    }
  }


  public void enQueue(int value)
  {
    linkedList.insertNode(value);
    System.out.println(value + " Inserted Successfully!");
  }


  public int deQueue()
  {
    int result = -1;
    if(isEmpty())
    {
      System.out.println("Queue is Empty!");
    }
    else
    {
      result = linkedList.head.value;
      linkedList.deleteNode();
    }
    return result;
  }


  public int peek()
  {
    int result = -1;
    if(isEmpty())
    {
      System.out.println("Queue is Empty!");
      return -1;
    }
    else
    {
      return linkedList.head.value;
    }
  }


  public void deleteQueue()
  {
    linkedList.head = null;
    linkedList.tail = null;
    System.out.println("Queue Deleted Successfully!");
  }
}


class Node 
{
  int value;
  Node next;
}


class LinkedList 
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
  public void insertNode(int nodeValue)
  {
    Node node = new Node();
    node.value = nodeValue;
    
    if(head == null) 
    {
      createSinglyLinkedList(nodeValue);
      return;
    }

    else
    {
      node.next = null;
      tail.next = node;
      tail = node;
    }
    size++;
  }


  // Delete Node
  public void deleteNode()
  {
    if(head == null) 
    {
      System.out.println("Linked List does not exist!");
      return;
    } 
    
    else
    {
      head = head.next;
      size--;
      if(size == 0) 
      {
        tail = null;
      }
    }
  }
}