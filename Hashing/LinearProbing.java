import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    LinearProbing l = new LinearProbing(13);

    l.insertInHashTable("The");
    l.insertInHashTable("quick");
    l.insertInHashTable("brown");
    l.insertInHashTable("fox");
    l.insertInHashTable("over");
    System.out.println(" ");

    System.out.println("Hash Table :-");
    l.displayHashTable();
    System.out.println(" ");
    
    l.searchKey("brown");
    System.out.println(" ");

    l.deleteKey("fox");
    l.searchKey("fox");
  }
}

class LinearProbing
{
  String hashTable[];
  int usedCells;

  public LinearProbing(int size)
  {
    hashTable = new String[size];
    usedCells = 0;
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


  public double getLoadFactor()
  {
    double loadFactor = usedCells * (1.0 / hashTable.length);
    return loadFactor;
  }


  public void reHash(String str)
  {
    usedCells = 0;
    ArrayList<String> data = new ArrayList<String>();
    for(String s: hashTable)
    {
      if(s != null)
      {
        data.add(s);
      }
    }
    data.add(str);
    hashTable = new String[hashTable.length * 2];
    for(String s: data)
    {
      insertInHashTable(s);
    }
  }


  public void insertInHashTable(String str)
  {
    double loadFactor = getLoadFactor();
    if(loadFactor >= 0.75)
    {
      reHash(str);
    }
    else
    {
      int index = hashFunction(str, hashTable.length);
      for(int i=index; i<index+hashTable.length; i++)
      {
        int newIndex = i % hashTable.length;
        if(hashTable[newIndex] == null)
        {
          hashTable[newIndex] = str;
          System.out.println("\"" + str + "\" inserted at location - " + newIndex);
          break;
        }
        else 
        {
          System.out.println(newIndex + " is already occupied. Trying to insert in the next empty cell.");
        }
      }
    }
    usedCells++;
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
    int index = hashFunction(str, hashTable.length);
    for(int i=index; i<index+hashTable.length; i++)
    {
      int newIndex = i % hashTable.length;
      if(hashTable[newIndex] != null && hashTable[newIndex].equals(str))
      {
        System.out.println("\"" + str + "\" found in the Hash Table at location - " + newIndex);
        return true;
      }
    }
    System.out.println("\"" + str + "\" not found in the Hash Table!");
    return false;
  }


  public void deleteKey(String str)
  {
    int index = hashFunction(str, hashTable.length);
    for(int i=index; i<index+hashTable.length; i++)
    {
      int newIndex = i % hashTable.length;
      if(hashTable[newIndex] != null && hashTable[newIndex].equals(str))
      {
        hashTable[newIndex] = null;
        return;
      }
    }
  }
}