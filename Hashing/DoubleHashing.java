import java.util.*;
public class Main
{
  public static void main(String args [])
  {
    DoubleHashing d = new DoubleHashing(13);

    d.insertInHashTable("The");
    d.insertInHashTable("quick");
    d.insertInHashTable("brown");
    d.insertInHashTable("fox");
    d.insertInHashTable("over");
    d.insertInHashTable("lazy");
    System.out.println(" ");

    System.out.println("Hash Table :-");
    d.displayHashTable();
    System.out.println(" ");
    
    d.searchKey("brown");
    System.out.println(" ");

    d.deleteKey("fox");
    d.searchKey("fox");
  }
}

class DoubleHashing
{
  String hashTable[];
  int usedCells;

  public DoubleHashing(int size)
  {
    hashTable = new String[size];
    usedCells = 0;
  }


  public int firstHashFunction(String str, int m)
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

  public int addAllDigits(int sum)
  {
    int value = 0;
    while(sum > 0)
    {
      value = sum % 10;
      sum = sum / 10;
    }
    return value;
  }


  public int secondHashFunction(String str, int m)
  {
    char ch[];
    ch = str.toCharArray();
    int i, sum;
    for(sum=0,i=0; i<str.length(); i++)
    {
      sum += ch[i];
    }
    while(sum > hashTable.length)
    {
      sum = addAllDigits(sum);
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
      int x = firstHashFunction(str, hashTable.length);
      int y = secondHashFunction(str, hashTable.length);
      for(int i=0; i<hashTable.length; i++)
      {
        int newIndex = (x + (i * y)) % hashTable.length;
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
    int x = firstHashFunction(str, hashTable.length);
    int y = secondHashFunction(str, hashTable.length);
    for(int i=0; i<hashTable.length; i++)
    {
      int newIndex = (x + (i * y)) % hashTable.length;
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
    int x = firstHashFunction(str, hashTable.length);
    int y = secondHashFunction(str, hashTable.length);
    for(int i=0; i<hashTable.length; i++)
    {
      int newIndex = (x + (i * y)) % hashTable.length;
      if(hashTable[newIndex] != null && hashTable[newIndex].equals(str))
      {
        hashTable[newIndex] = null;
        return;
      }
    }
  }
}