public class BinaryTreeUsingArray
{
  public static void main(String args[])
  {
    BinaryTree tree = new BinaryTree(9);

    tree.insertNode(1);
    tree.insertNode(2);
    tree.insertNode(3);
    tree.insertNode(4);
    tree.insertNode(5);
    tree.insertNode(6);
    tree.insertNode(7);
    tree.insertNode(8);
    tree.insertNode(9);

    System.out.print("PreOrder Traversal - "); 
    tree.preOrder(1);
    System.out.println(" ");

    System.out.print("InOrder Traversal - "); 
    tree.inOrder(1);
    System.out.println(" ");

    System.out.print("PostOrder Traversal - "); 
    tree.postOrder(1);
    System.out.println(" ");

    System.out.print("LevelOrder Traversal - "); 
    tree.levelOrder();
    System.out.println(" ");

    System.out.println(tree.searchNode(7));

    tree.deleteNode(6);
    tree.levelOrder();
    System.out.println(" ");

    tree.deleteBinaryTree();
  }
}

class BinaryTree
{
  int arr[];
  int lastUsedIndex;

  public BinaryTree(int size)
  {
    arr = new int[size + 1];
    this.lastUsedIndex = 0;
  }


  public boolean isFull()
  {
    if(arr.length - 1 == lastUsedIndex)
    {
      return true;
    }
    else
    {
      return false;
    }
  }


  public void insertNode(int value)
  {
    if(!isFull())
    {
      arr[lastUsedIndex + 1] = value;
      lastUsedIndex++;
    }
    else
    {
      System.out.println("Cannot insert " + value + ". Tree is full!");
    }
  }


  public void preOrder(int index)
  {
    if(index > lastUsedIndex)
    {
      return;
    }
    System.out.print(arr[index] + " ");
    preOrder(index * 2);
    preOrder((index * 2) + 1);
  }


  public void inOrder(int index)
  {
    if(index > lastUsedIndex)
    {
      return;
    }
    inOrder(index * 2);
    System.out.print(arr[index] + " ");
    inOrder((index * 2) + 1);
  }


  public void postOrder(int index)
  {
    if(index > lastUsedIndex)
    {
      return;
    }
    postOrder(index * 2);
    postOrder((index * 2) + 1);
    System.out.print(arr[index] + " ");
  }


  public void levelOrder()
  {
    for(int i = 1; i <= lastUsedIndex; i++)
    {
      System.out.print(arr[i] + " ");
    }
  }


  public int searchNode(int value)
  {
    for(int i = 1; i <= lastUsedIndex; i++)
    {
      if(arr[i] == value)
      {
        System.out.print(value + " found in the Tree at location - ");
        return i;
      }
    }
    System.out.println(value  + " not found in the Tree!");
    return -1;
  }


  public void deleteNode(int value)
  {
    int location = 0;
    for(int i = 1; i <= lastUsedIndex; i++)
    {
      if(arr[i] == value)
      {
        location = i;
      }
    }
    if(location == -1)
    {
      return;
    }
    else
    {
      arr[location] = arr[lastUsedIndex];
      lastUsedIndex--;
      System.out.println("Node with the value of " + value + " deleted successfully!");
    }
  }


  public void deleteBinaryTree()
  {
    arr = null;
    System.out.println("Binary Tree Deleted!");
  }
}