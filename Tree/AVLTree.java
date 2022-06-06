import java.util.*;
public class AVLTree
{
  public static void main(String[] args)
  {
    AVL tree = new AVL();
    tree.insertNode(5);
    tree.insertNode(10);
    tree.insertNode(15);
    tree.insertNode(20);
    tree.levelOrder();
    
    tree.deleteNode(5);
    tree.levelOrder();

    tree.deleteAVL();
    tree.levelOrder();
  }
}

class Node 
{
  int value;
  int height;
  Node left;
  Node right;

  public Node()
  {
    this.height = 0;
  }
}

class AVL
{
  Node root;

  public AVL()
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


  public int getHeight(Node node)
  {
    if(node == null)
    {
      return 0;
    }
    return node.height;
  }

  public Node rotateRight(Node disbalancedNode)
  {
    Node newRoot = disbalancedNode.left;
    disbalancedNode.left = disbalancedNode.left.right;
    newRoot.right = disbalancedNode;
    disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
  }

  public Node rotateLeft(Node disbalancedNode)
  {
    Node newRoot = disbalancedNode.right;
    disbalancedNode.right = disbalancedNode.right.left;
    newRoot.left = disbalancedNode;
    disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
  }

  public int getBalance(Node node) 
  {
    if(node == null)
    {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  public Node insert(Node node, int value)
  { 
    if(node == null)
    {
      Node newNode = new Node();
      newNode.value = value;
      newNode.height = 1;
      return newNode;
    }
    else if(value < node.value)
    {
      node.left = insert(node.left, value);
    }
    else
    {
      node.right = insert(node.right, value);
    }

    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    int balance = getBalance(node);

    if(balance > 1 && value < node.left.value)
    { 
      return rotateRight(node);
    }
    if(balance > 1 && value > node.left.value)
    {
      node.left = rotateLeft(node.left);
      return rotateRight(node);
    }
    if (balance < -1 && value > node.right.value) 
    {
      return rotateLeft(node);
    }
    if (balance < -1 && value < node.right.value) 
    {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }
    return node;
  }

  public void insertNode(int value)
  {
    root = insert(root, value);
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

  public Node delete(Node node, int value)
  {
    if(node == null)
    {
      System.out.println(value + " not found!");
      return null;
    }
    if(value < node.value)
    {
      node.left = delete(node.left, value);
    }
    else if(value > node.value)
    {
      node.right = delete(node.right, value);
    }
    else 
    {
      if(node.left != null && node.right != null)
      {
        Node tempNode = node;
        Node minNodeForRight = minimumNode(tempNode.right);
        node.value = minNodeForRight.value;
        node.right = delete(node.right, minNodeForRight.value);
      }
      else if(node.left != null)
      {
        node = node.left;
      }
      else if(node.right != null)
      {
        node = node.right;
      }
      else
      {
        node = null;
      }
    }
    int balance = getBalance(node);
    if(balance > 1 && getBalance(node.left) >= 0) 
    {
      return rotateRight(node);
    }
    if(balance > 1 && getBalance(node.left) < 0) 
    {
     node.left = rotateLeft(node.left);
      return rotateRight(node);
    }
    if(balance < -1 && getBalance(node.right) <= 0) 
    {
      return rotateLeft(node);
    }
    if(balance < -1 && getBalance(node.right) > 0) 
    {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }
    return node;
  }

  public void deleteNode(int value)
  {
    root = delete(root, value);
  }

  public void deleteAVL()
  {
    root = null;
    System.out.println("AVL Tree Deleted!");
  }
}