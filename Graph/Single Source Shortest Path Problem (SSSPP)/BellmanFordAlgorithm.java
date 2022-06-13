import java.util.*;
public class BellmanFordAlgorithm
{
  public static void main(String[] args)
  {
    ArrayList<Node> vertices = new ArrayList<Node>();

    // Refer Graph 2.PNG
    vertices.add(new Node("A", 0));
    vertices.add(new Node("B", 1));
    vertices.add(new Node("C", 2));
    vertices.add(new Node("D", 3));
    vertices.add(new Node("E", 4));
    vertices.add(new Node("F", 5));
    vertices.add(new Node("G", 6));

    Graph graph = new Graph(vertices);

    graph.addWeightedEdge(0, 1, 2);
    graph.addWeightedEdge(0, 2, 5);
    graph.addWeightedEdge(1, 2, 6);
    graph.addWeightedEdge(1, 3, 1);
    graph.addWeightedEdge(1, 4, 3);
    graph.addWeightedEdge(2, 5, 8);
    graph.addWeightedEdge(2, 4, 4);
    graph.addWeightedEdge(4, 6, 9);
    graph.addWeightedEdge(5, 6, 7);

    graph.BellmanFord(vertices.get(0));
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

class Graph
{
  ArrayList<Node> vertices = new ArrayList<Node>();

  public Graph(ArrayList<Node> vertices)
  {
    this.vertices = vertices;
  }

  public void addWeightedEdge(int i, int j, int costOfEdge)
  {
    Node first = vertices.get(i);
    Node second = vertices.get(j);
    first.neighbors.add(second);
    first.weights.put(second, costOfEdge);
  }

  public void BellmanFord(Node sourceNode)
  {
    sourceNode.distance = 0;
    for(int i=0; i<vertices.size(); i++) 
    {
      for(Node currentNode: vertices)
      {
        for(Node neighbor: currentNode.neighbors)
        {
          if(neighbor.distance > currentNode.distance + currentNode.weights.get(neighbor))
          {
            neighbor.distance = currentNode.distance + currentNode.weights.get(neighbor);
            neighbor.parent = currentNode;
          }
        }
      }
    }
    System.out.println("Checking for Negative Cycle");
    for(Node currentNode: vertices)
    {
      for(Node neighbor: currentNode.neighbors)
      {
        if(neighbor.distance > currentNode.distance + currentNode.weights.get(neighbor))
        {
          System.out.println("Negative Cycle Found");
          System.out.println(" ");
          System.out.println("Vertex Name - " + neighbor.name);
          System.out.println("Old Cost - " + neighbor.distance);
          int newDistance = currentNode.distance + currentNode.weights.get(neighbor);
          System.out.println("New Cost - " + newDistance);
          return;
        }
      }
    }
    System.out.println("Negative Cycle not found!");
    System.out.println(" ");
    for(Node nodeToCkeck: vertices)
    {
      System.out.print("From A to " + nodeToCkeck + ", Distance = " + nodeToCkeck.distance + ", Path = ");
      displayPath(nodeToCkeck);
      System.out.println(" ");
    }
  }

  public void displayPath(Node node)
  {
    if(node.parent != null)
    {
      displayPath(node.parent);
    }
    System.out.print(node.name + " ");
  }
}