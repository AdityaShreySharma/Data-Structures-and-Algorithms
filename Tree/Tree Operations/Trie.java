import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    Trie t = new Trie();

    t.insertNode("API");
    t.insertNode("APIS");

    t.searchNode("API");
    t.searchNode("AP");
    t.searchNode("DSA");

    t.searchNode("API");
    t.deleteNode("API");
    t.searchNode("API");
  }
}

class TrieNode
{
  Map<Character, TrieNode> children;
  boolean endOfString;

  public TrieNode()
  {
    children = new HashMap<>();
    endOfString = false;
  }
}

class Trie
{
  TrieNode root;

  public Trie()
  {
    root = new TrieNode();
  }


  public void insertNode(String str)
  {
    TrieNode currentNode = root;
    for(int i=0; i<str.length(); i++)
    {
      char ch = str.charAt(i);
      TrieNode node = currentNode.children.get(ch);
      if(node == null)
      {
        node = new TrieNode();
        currentNode.children.put(ch, node);
      }
      currentNode = node;
    }
    currentNode.endOfString = true;
  }


  public boolean searchNode(String str)
  {  
    TrieNode currentNode = root;
    for(int i=0; i<str.length(); i++)
    {
      char ch = str.charAt(i);
      TrieNode node = currentNode.children.get(ch);
      if(node == null)
      {
        System.out.println("Node not found!");
        return false;
      }
      currentNode = node;
    }
    if(currentNode.endOfString == true)
    {
      System.out.println("Node found in the Trie!");
      return true;
    }
    else
    {
      System.out.println("Node not found! It is a prefix of another string.");
    }
    return currentNode.endOfString;
  }


  public boolean delete(TrieNode parentNode, String str, int index)
  {
    char ch = str.charAt(index);
    TrieNode currentNode = parentNode.children.get(ch);
    boolean canThisNodeBeDeleted;

    // Some other prefix of a string is same as the one to be deleted
    if(currentNode.children.size() > 1)
    {
      delete(currentNode, str, index + 1);
      return false;
    }
    
    // The string is a prefix of another string
    if(index == str.length() - 1)
    {
      if(currentNode.children.size() >= 1)
      {
        currentNode.endOfString = false;
        return false;
      }
      else
      {
        parentNode.children.remove(ch);
        return true;
      }
    }

    // Another string is a prefix of this string 
    if(currentNode.endOfString == true)
    {
      delete(currentNode, str, index + 1);
      return false;
    }
    canThisNodeBeDeleted = delete(currentNode, str, index + 1);
    
    // No node depends on this string
    if(canThisNodeBeDeleted == true)
    {
      parentNode.children.remove(ch);
      return true;
    }
    else
    {
      return false;
    }
  }

  public void deleteNode(String str)
  {
    if(searchNode(str) == true)
    {
      delete(root, str, 0);
    }
  }
}