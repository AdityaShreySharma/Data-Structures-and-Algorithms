import java.util.*;
public class BinaryTreeUsingLinkedList
{
  public static void main(String[] args)
  {
    BinaryTree tree = new BinaryTree();

    tree.insertNode(1);
    tree.insertNode(2);
    tree.insertNode(3);
    tree.insertNode(4);
    tree.insertNode(5);
    tree.insertNode(6);
    tree.insertNode(7);
    tree.insertNode(8);
    tree.insertNode(9);
    tree.insertNode(10);

    tree.levelOrder();
    tree.deleteNode(7);
    tree.levelOrder();

    tree.deleteBinaryTree();
  }
}

class Node 
{
  int value;
  Node left;
  Node right;
  int height;
}

class BinaryTree
{
  Node root;

  public BinaryTree()
  {
    root = null;
  }


  public void preOrder(Node node)
  {
    if(node == null)
    {
      return;
    }
    System.out.print(node.value + " ");
    preOrder(node.left);
    preOrder(node.right);
    System.out.println(" ");
  }


  public void inOrder(Node node)
  {
    if(node == null)
    {
      return;
    }
    preOrder(node.left);
    System.out.print(node.value + " ");
    preOrder(node.right);
    System.out.println(" ");
  }


  public void postOrder(Node node)
  {
    if(node == null)
    {
      return;
    }
    preOrder(node.left);
    preOrder(node.right);
    System.out.print(node.value + " ");
    System.out.println(" ");
  }


  public void levelOrder()
  {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty())
    {
      Node presentNode = queue.remove();
      System.out.print(presentNode.value + " ");
      if(presentNode.left != null)
      {
        queue.add(presentNode.left);
      }
      if(presentNode.right != null)
      {
        queue.add(presentNode.right);
      }
    }
    System.out.println(" ");
  }


  public void searchNode(int value)
  {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty())
    {
      Node presentNode = queue.remove();
      if(presentNode.value == value)
      {
        System.out.println(value + " found in the Tree!");
        return;
      }
      else
      {
        if(presentNode.left != null)
        {
          queue.add(presentNode.left);
        }
        if(presentNode.right != null)
        {
          queue.add(presentNode.right);
        }
      } 
    }
    System.out.println(value + " not found in the Tree!");
  }


  public void insertNode(int value)
  {
    Node newNode = new Node();
    newNode.value = value;
    if(root == null)
    {
      root = newNode;
      return;
    }
    else
    {
      Queue<Node> queue = new LinkedList<Node>();
      queue.add(root);
      while(!queue.isEmpty())
      {
        Node presentNode = queue.remove();
        if(presentNode.left == null)
        {
          presentNode.left = newNode;
          break;
        }
        else if(presentNode.right == null)
        {
          presentNode.right = newNode;
          break;
        }
        else
        {
          queue.add(presentNode.left);
          queue.add(presentNode.right);
        }
      }
    }
  }


  public Node getDeepestNode()
  {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    Node presentNode = null;
    while(!queue.isEmpty())
    {
      presentNode = queue.remove();
      if(presentNode.left != null)
      {
        queue.add(presentNode.left);
      }
      if(presentNode.right != null)
      {
        queue.add(presentNode.right);
      }
    }
    return presentNode;
  }
  

  public void deleteDeepestNode()
  {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    Node previousNode, presentNode = null;
    while(!queue.isEmpty())
    {
      previousNode = presentNode;
      presentNode = queue.remove();
      if(presentNode.left == null)
      {
        previousNode.right = null;
        return;
      }
      else if(presentNode.right == null)
      {
        presentNode.left = null;
        return;
      }
      queue.add(presentNode.left);
      queue.add(presentNode.right);
    }
  }
  

  public void deleteNode(int value)
  {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty())
    {
      Node presentNode = queue.remove();
      if(presentNode.value == value)
      {
        presentNode.value = getDeepestNode().value;
        deleteDeepestNode();
        System.out.println("Node with value of " + value + " deleted!");
        return;
      }
      else
      {
        if(presentNode.left != null)
        {
          queue.add(presentNode.left);
        }
        if(presentNode.right != null)
        {
          queue.add(presentNode.right);
        }
      }
    }
    System.out.println("Node does not exist!");
  }


  public void deleteBinaryTree() 
  {
    root = null;
    System.out.println("Binary Tree Deleted!");
  }
}