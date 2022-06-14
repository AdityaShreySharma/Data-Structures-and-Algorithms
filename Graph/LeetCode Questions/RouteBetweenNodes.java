import java.util.*;
public class RouteBetweenNodes
{
  public static void main(String[] args)
  {
    ArrayList<Node> vertices = new ArrayList<Node>();
    
    // Refer Graph.PNG
    vertices.add(new Node("A", 0));
    vertices.add(new Node("B", 1));
    vertices.add(new Node("C", 2));
    vertices.add(new Node("D", 3));
    vertices.add(new Node("E", 4));
    vertices.add(new Node("F", 5));
    vertices.add(new Node("G", 6));
    vertices.add(new Node("H", 7));
    vertices.add(new Node("I", 8));
    vertices.add(new Node("J", 9));

    Graph graph = new Graph(vertices);

    graph.addDirectedEdge(0, 1);
    graph.addDirectedEdge(0, 2);
    graph.addDirectedEdge(0, 3);
    graph.addDirectedEdge(1, 9);
    graph.addDirectedEdge(2, 6);
    graph.addDirectedEdge(4, 0);
    graph.addDirectedEdge(4, 5);
    graph.addDirectedEdge(5, 8);
    graph.addDirectedEdge(6, 7);
    graph.addDirectedEdge(6, 3);
    graph.addDirectedEdge(7, 8);


    boolean result = graph.searchNode(vertices.get(0), vertices.get(4));
    System.out.println(result);
  }
}

class Node
{
  String name;
  int index;
  boolean isVisited;
  Node parent;
  Graph.State state;

  ArrayList<Node> neighbors = new ArrayList<Node>();

  public Node(String name, int index)
  {
    this.name = name;
    this.index = index;
    this.isVisited = false;
  }
}

class Graph
{
  ArrayList<Node> vertices = new ArrayList<Node>();

  public enum State 
  {
    Unvisited, Visited, Visiting;
  }

  public Graph(ArrayList<Node> vertices)
  {
    this.vertices = vertices;
  }

  public void addDirectedEdge(int i, int j)
  {
    Node first = vertices.get(i);
    Node second = vertices.get(j);
    first.neighbors.add(second);
  }

  public boolean searchNode(Node start, Node end)
  {
    LinkedList<Node> queue = new LinkedList<Node>();
    for(Node node : vertices)
    {
      node.state = State.Unvisited;
    }
    start.state = State.Visiting;
    queue.add(start);
    Node currentNode;
    while(!queue.isEmpty())
    {
      currentNode = queue.removeFirst();
      if(currentNode != null)
      {
        for(Node node: currentNode.neighbors)
        {
          if(node.state == State.Unvisited)
          {
            if(node == end)
            {
              return true;
            }
            else
            {
              node.state = State.Visiting;
              queue.add(node);
            }
          }
        }
        currentNode.state = State.Visited;
      }
    }
    return false;
  }
}