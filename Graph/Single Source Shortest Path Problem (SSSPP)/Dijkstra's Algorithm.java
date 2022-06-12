import java.util.*;
public class Dijkstra
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

    graph.Dijkstra(vertices.get(0));
  }
}

class Node implements Comparable<Node>
{
  String name;
  int index;
  ArrayList<Node> neighbors = new ArrayList<Node>();
  HashMap<Node, Integer> weights = new HashMap<>();
  boolean isVisited = false;
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

  @Override
  public int compareTo(Node o)
  {
    return this.distance - o.distance;
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

  public void Dijkstra(Node node)
  {
    PriorityQueue<Node> queue = new PriorityQueue<Node>();
    node.distance = 0;
    queue.addAll(vertices);

    while(!queue.isEmpty())
    {
      Node currentNode = queue.remove();
      for(Node neighbor : currentNode.neighbors)
      {
        if(queue.contains(neighbor))
        {
          if(neighbor.distance > currentNode.distance + currentNode.weights.get(neighbor))
          {
            neighbor.distance = currentNode.distance + currentNode.weights.get(neighbor);
            neighbor.parent = currentNode;
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }
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