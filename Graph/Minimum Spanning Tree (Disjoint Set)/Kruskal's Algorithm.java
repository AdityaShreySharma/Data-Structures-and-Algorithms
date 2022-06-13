import java.util.*;
public class KruskalAlgorithm
{
  public static void main(String args[])
  {
    ArrayList<Node> vertices = new ArrayList<Node>();

    // Refer Graph.PNG
    vertices.add(new Node("A", 0));
    vertices.add(new Node("B", 1));
    vertices.add(new Node("C", 2));
    vertices.add(new Node("D", 3));
    vertices.add(new Node("E", 4));

    Kruskal graph = new Kruskal(vertices);

    graph.addWeightedUndirectedEdge(0, 1, 5);
    graph.addWeightedUndirectedEdge(0, 2, 13);
    graph.addWeightedUndirectedEdge(0, 4, 15);
    graph.addWeightedUndirectedEdge(1, 2, 10);
    graph.addWeightedUndirectedEdge(1, 3, 8);
    graph.addWeightedUndirectedEdge(2, 3, 6);
    graph.addWeightedUndirectedEdge(2, 4, 20);

    graph.kruskal();
  }
}

class Node 
{
  String name;
  int index;
  ArrayList<Node> neighbors = new ArrayList<Node>();
  HashMap<Node, Integer> weights = new HashMap<>();
  DisjointSet set;

  public Node(String name, int index)
  {
    this.name = name;
    this.index = index;
  }

  @Override
  public String toString()
  { 
    return name;
  }
}

class UndirectedEdge
{
  Node first;
  Node second;
  int weight;

  public UndirectedEdge(Node first, Node second, int weight)
  {
    this.first = first;
    this.second = second;
    this.weight = weight;
  }

  @Override
  public String toString()
  { 
    return "Edge " + first + " -> " + second + ", Weight = " + weight;
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

class Kruskal
{
  ArrayList<Node> vertices = new ArrayList<Node>();
  ArrayList<UndirectedEdge> edges = new ArrayList<UndirectedEdge>();

  public Kruskal(ArrayList<Node> vertices)
  {
    this.vertices = vertices;
  }

  public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight)
  {
    UndirectedEdge edge = new UndirectedEdge(vertices.get(firstIndex), vertices.get(secondIndex), weight);
    Node first = edge.first;
    Node second = edge.second;
    first.neighbors.add(second);
    second.neighbors.add(first);
    first.weights.put(second, weight);
    second.weights.put(first, weight);
    edges.add(edge);
  }

  public void kruskal()
  {
    DisjointSet set = new DisjointSet();
    set.createSet(vertices);
    Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>()
    {
      @Override
      public int compare(UndirectedEdge edge1, UndirectedEdge edge2)
      { 
        return edge1.weight - edge2.weight;
      }
    };
    Collections.sort(edges, comparator);
    int cost = 0;
    for(UndirectedEdge edge : edges)
    {
      Node first = edge.first;
      Node second = edge.second;
      if(!set.findSet(first).equals(set.findSet(second)))
      {
        set.union(first, second);
        cost += edge.weight;
        System.out.println(edge);
      }
    }
    System.out.println("Total Cost of MST = " + cost);
  }
}