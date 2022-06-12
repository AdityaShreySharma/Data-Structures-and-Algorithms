import java.util.*;
public class BFSForSSSPP
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

    Graph graph = new Graph(vertices);

    graph.addUndirectedEdge(0, 1);
    graph.addUndirectedEdge(0, 2);
    graph.addUndirectedEdge(1, 3);
    graph.addUndirectedEdge(1, 6);
    graph.addUndirectedEdge(2, 3);
    graph.addUndirectedEdge(2, 4);
    graph.addUndirectedEdge(3, 5);
    graph.addUndirectedEdge(4, 5);
    graph.addUndirectedEdge(5, 6);

    graph.BFSForSSSPP(vertices.get(0));
  }
}

class Node
{
  String name;
  int index;
  boolean isVisited;
  Node parent;
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

  public Graph(ArrayList<Node> vertices)
  {
    this.vertices = vertices;
  }

  public void addUndirectedEdge(int i, int j)
  {
    Node first = vertices.get(i);
    Node second = vertices.get(j);
    first.neighbors.add(second);
    second.neighbors.add(first);
  }

  public void BFSForSSSPP(Node node)
  {
    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(node);
    while(!queue.isEmpty())
    {
      Node currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print("Path for Node " + currentNode.name + " = ");
      displayPath(currentNode);
      System.out.println(" ");
      for(Node neighbor: currentNode.neighbors)
      {
        if(!neighbor.isVisited)
        {
          queue.add(neighbor);
          neighbor.isVisited = true;
          neighbor.parent = currentNode;
        }
      }
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