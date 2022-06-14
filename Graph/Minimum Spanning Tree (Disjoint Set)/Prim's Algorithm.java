import java.util.*;
public class PrimAlgorithm
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

    Prim graph = new Prim(vertices);

    graph.addWeightedUndirectedEdge(0, 1, 5);
    graph.addWeightedUndirectedEdge(0, 2, 13);
    graph.addWeightedUndirectedEdge(0, 4, 15);
    graph.addWeightedUndirectedEdge(1, 2, 10);
    graph.addWeightedUndirectedEdge(1, 3, 8);
    graph.addWeightedUndirectedEdge(2, 3, 6);
    graph.addWeightedUndirectedEdge(2, 4, 20);

    graph.prim(vertices.get(4));
  }
}

class Node implements Comparable<Node>
{
  String name;
  int index;
  ArrayList<Node> neighbors = new ArrayList<Node>();
  HashMap<Node, Integer> weights = new HashMap<>();
  Node parent;
  int distance;

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

  @Override
  public int compareTo(Node other)
  {
    if(this.distance > other.distance)
    {
      return 1;
    }
    else
    {
      return -1;
    }
  }
}

class Prim
{
  ArrayList<Node> vertices = new ArrayList<Node>();

  public Prim(ArrayList<Node> vertices)
  {
    this.vertices = vertices;
  }

  public void addWeightedUndirectedEdge(int i, int j, int costOfEdge)
  {
    Node first = vertices.get(i);
    Node second = vertices.get(j);
    first.neighbors.add(second);
    second.neighbors.add(first);
    first.weights.put(second, costOfEdge);
    second.weights.put(first, costOfEdge);
  }

  public void prim(Node node)
  {
    for(int i=0; i<vertices.size(); i++)
    {
      vertices.get(i).distance = Integer.MAX_VALUE;
    }
    node.distance = 0;

    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.addAll(vertices);

    while(!queue.isEmpty())
    {
      Node currentNode = queue.remove();
      for(Node neighbor: currentNode.neighbors)
      {
        if(queue.contains(neighbor))
        {
          if(neighbor.distance > currentNode.weights.get(neighbor))
          {
            neighbor.distance = currentNode.weights.get(neighbor);
            neighbor.parent = currentNode;
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    int cost = 0;
    for(Node nodeToCheck: vertices)
    {
      System.out.print("Node " + nodeToCheck + ", Cost = " + nodeToCheck.distance + ", Parent = " + nodeToCheck.parent);
      System.out.println(" ");    
      cost += nodeToCheck.distance;
    }
    System.out.println(" ");
    System.out.println("Total Cost of MST = " + cost);
  }
}