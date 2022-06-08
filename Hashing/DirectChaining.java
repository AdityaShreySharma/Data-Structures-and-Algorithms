import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    DirectChaining d = new DirectChaining(15);

    d.insertInHashTable("The");
    d.insertInHashTable("quick");
    d.insertInHashTable("brown");
    d.insertInHashTable("fox");
    d.insertInHashTable("over");

    d.displayHashTable();
  }
}

@SuppressWarnings("unchecked")
class DirectChaining
{
  LinkedList<String>[] hashTable;
  int maxChainSize = 5;

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


  public void insertInHashTable(String str)
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
}