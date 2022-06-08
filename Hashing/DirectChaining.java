import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    DirectChaining d = new DirectChaining(15);

    d.insertKey("The");
    d.insertKey("quick");
    d.insertKey("brown");
    d.insertKey("fox");
    d.insertKey("over");
    d.displayHashTable();
    System.out.println(" ");

    d.searchKey("brown");
    System.out.println(" ");

    d.deleteKey("brown");
    d.searchKey("brown");
  }
}

@SuppressWarnings("unchecked")
class DirectChaining
{
  LinkedList<String>[] hashTable;

  public DirectChaining(int size)
  {
    hashTable = new LinkedList[size];
  }

  public int hashFunction(String str, int m)
  {
    char ch[];
    ch = str.toCharArray();
    int i, sum;
    for(sum=0,i=0; i<str.length(); i++)
    {
      sum += ch[i];
    }
    return sum % m;
  }


  public void insertKey(String str)
  {
    int newIndex = hashFunction(str, hashTable.length);
    if(hashTable[newIndex] == null)
    {
      hashTable[newIndex] = new LinkedList<String>();
      hashTable[newIndex].add(str);
    }
    else
    {
      hashTable[newIndex].add(str);
    }
  }


  public void displayHashTable()
  {
    if(hashTable == null)
    {
      System.out.println("Hash Table doesn't exist!");
    }
    else
    {
      for(int i=0; i<hashTable.length; i++)
      {
        System.out.println("Index - " + i + ", Key - " + hashTable[i]);
      }
    }
  }


  public boolean searchKey(String str) 
  {
    int newIndex = hashFunction(str, hashTable.length);
    if(hashTable[newIndex] != null && hashTable[newIndex].contains(str))
    {
      System.out.println("\"" + str + "\" found in the Hash Table at location - " + newIndex);
      return true;
    }
    else
    {
      System.out.println("\"" + str + "\" not found in the Hash Table!");
      return false;
    }
  }


  public void deleteKey(String str) 
  {
    int newIndex = hashFunction(str, hashTable.length);
    boolean result = searchKey(str);
    if(result == true)
    {
      hashTable[newIndex].remove(str);
    }
  }
}