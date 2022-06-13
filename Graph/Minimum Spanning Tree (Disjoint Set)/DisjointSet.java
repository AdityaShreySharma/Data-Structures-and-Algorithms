import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    ArrayList<Node> vertices = new ArrayList<Node>();

    // Refer Graph 2.PNG
    vertices.add(new Node("A", 0));
    vertices.add(new Node("B", 1));
    vertices.add(new Node("C", 2));
    vertices.add(new Node("D", 3));

    DisjointSet ds = new DisjointSet();
    ds.createSet(vertices);
    
    Node first = vertices.get(0);
    Node second = vertices.get(1);
    
    DisjointSet output = ds.findSet(second);
    output.displaySetNodes();

    ds.union(first, second);
    output = ds.findSet(second);
    output.displaySetNodes();
  }
}

class Node 
{
  String name;
  int index;
  ArrayList<Node> neighbors = new ArrayList<Node>();
  HashMap<Node, Integer> weights = new HashMap<>();
  Node parent;
  int distance;
  DisjointSet set;

  public Node(String name, int index)
  {
    this.name = name;
    this.index = index;
    distance = Integer.MAX_VALUE;
  }

  @Override
  public String toString()
  { 
    return name;
  }
}

class DisjointSet
{
  ArrayList<Node> vertices = new ArrayList<Node>();

  public void createSet(ArrayList<Node> vertices)
  {
    for(Node node: vertices)
    {
      DisjointSet set = new DisjointSet();
      set.vertices.add(node);
      node.set = set;
    }
  }

  public DisjointSet findSet(Node node)
  {
    return node.set;
  }

  public DisjointSet union(Node node1, Node node2)
  {
    if(node1.set.equals(node2.set))
    {
      return null;
    }
    else
    {
      DisjointSet set1 = node1.set;
      DisjointSet set2 = node2.set;
      if(set1.vertices.size() > set2.vertices.size())
      {
        ArrayList<Node> nodeSet2 = set2.vertices;
        for(Node node: nodeSet2)
        {
          node.set = set1;
          set1.vertices.add(node);
        }
        return set1;
      }
      else
      {
        ArrayList<Node> nodeSet1 = set1.vertices;
        for(Node node: nodeSet1)
        {
          node.set = set2;
          set2.vertices.add(node);
        }
        return set2;
      }
    }
  }

  public void displaySetNodes()
  {
    for(Node node: vertices)
    { 
      System.out.print(node + " ");
    }
    System.out.println();
  }
}