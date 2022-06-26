import java.util.*;
public class BinarySearchTree
{
  public static void main(String[] args)
  {
    Tree tree = new Tree();

    tree.insertNode(70);
    tree.insertNode(50);
    tree.insertNode(90);
    tree.insertNode(30);
    tree.insertNode(60);
    tree.insertNode(80);
    tree.insertNode(100);
    tree.insertNode(20);
    tree.insertNode(40);

    System.out.print("PreOrder Traversal - "); 
    tree.preOrder(tree.root);
    System.out.println(" ");

    System.out.print("InOrder Traversal - "); 
    tree.inOrder(tree.root);
    System.out.println(" ");

    System.out.print("PostOrder Traversal - "); 
    tree.postOrder(tree.root);
    System.out.println(" ");

    System.out.print("LevelOrder Traversal - ");
    tree.levelOrder();
    
    tree.searchNode(tree.root, 60);

    tree.deleteNode(tree.root, 70);
    tree.levelOrder();

    tree.deleteBinarySearchTree();
    tree.levelOrder();
  }
}

class Node 
{
  int value;
  Node left;
  Node right;
}

class Tree
{
  Node root;

  public Tree()
  {
    root = null;
  }


  public Node insert(Node currentNode, int value)
  {
    if(currentNode == null)
    {
      Node newNode = new Node();
      newNode.value = value;
      return newNode;
    }
    else if(value <= currentNode.value)
    {
      currentNode.left = insert(currentNode.left, value);
      return currentNode;
    }
    else
    {
      currentNode.right = insert(currentNode.right, value);
      return currentNode;
    }
  }

  public void insertNode(int value)
  {
    root = insert(root, value);
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
  }


  public void inOrder(Node node)
  {
    if(node == null)
    {
      return;
    }
    inOrder(node.left);
    System.out.print(node.value + " ");
    inOrder(node.right);
  }


  public void postOrder(Node node)
  {
    if(node == null)
    {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
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


  public Node searchNode(Node node, int value)
  {
    if(node == null)
    {
      System.out.println(value + " not found!");
      return null;
    }
    else if(node.value == value)
    {
      System.out.println(value + " found in BST!");
      return node;
    }
    else if(value < node.value)
    {
      return searchNode(node.left, value);
    }
    else
    {
      return searchNode(node.right, value);
    }
  }

  
  public static Node minimumNode(Node root)
  {
    if(root.left == null)
    {
      return root;
    }
    else
    {
      return minimumNode(root.left);
    }
  }

  public Node deleteNode(Node root, int value)
  {
    if(root == null)
    {
      System.out.println(value + " not found!");
      return null;
    }
    if(value < root.value)
    {
      root.left = deleteNode(root.left, value);
    }
    else if(value > root.value)
    {
      root.right = deleteNode(root.right, value);
    }
    else 
    {
      if(root.left != null && root.right != null)
      {
        Node tempNode = root;
        Node minNodeForRight = minimumNode(tempNode.right);
        root.value = minNodeForRight.value;
        root.right = deleteNode(root.right, minNodeForRight.value);
      }
      else if(root.left != null)
      {
        root = root.left;
      }
      else if(root.right != null)
      {
        root = root.right;
      }
      else
      {
        root = null;
      }
    }
    return root;
  }

  
  public void deleteBinarySearchTree()
  {
    root = null;
    System.out.println("BST Deleted!");
  }
}