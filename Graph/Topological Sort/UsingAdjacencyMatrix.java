import java.util.*;
public class TopologicalSort
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

    Graph graph = new Graph(vertices);

    graph.addDirectedEdge(0, 2);
    graph.addDirectedEdge(2, 4);
    graph.addDirectedEdge(4, 7);
    graph.addDirectedEdge(4, 5);
    graph.addDirectedEdge(5, 6);
    graph.addDirectedEdge(1, 2);
    graph.addDirectedEdge(1, 3);
    graph.addDirectedEdge(3, 5);

    System.out.println(graph.toString());

    graph.topologicalSort();
    System.out.println(" ");
  }
}

class Node
{
  String name;
  int index;
  boolean isVisited;

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
  int adjacencyMatrix[][];

  public Graph(ArrayList<Node> vertices)
  {
    this.vertices = vertices;
    this.adjacencyMatrix = new int[vertices.size()][vertices.size()];
  }

  public void addDirectedEdge(int i, int j)
  {
    adjacencyMatrix[i][j] = 1;
  }

  public ArrayList<Node> getNeighbors(Node node)
  {
    ArrayList<Node> neighbors = new ArrayList<Node>();
    int nodeIndex = node.index;
    for(int i=0; i<adjacencyMatrix.length; i++)
    {
      if(adjacencyMatrix[nodeIndex][i] == 1)
      {
        neighbors.add(vertices.get(i));
      }
    }
    return neighbors;
  }

  public void visitNodes(Node node, Stack<Node> stack) 
  {
    ArrayList<Node> neighbors = getNeighbors(node);
    for(Node neighbor : neighbors)
    {
      if(!neighbor.isVisited)
      {
        visitNodes(neighbor, stack);
      }
    }
    node.isVisited = true;
    stack.push(node);
  }

  public void topologicalSort()
  {
    Stack<Node> stack = new Stack<Node>();
    for(Node node : vertices)
    {
      if(!node.isVisited)
      {
        visitNodes(node, stack);
      }
    }
    while(!stack.isEmpty())
    {
      System.out.print(stack.pop().name + " ");
    }
  }

  public String toString() 
  {
    StringBuilder sb = new StringBuilder();
    sb.append("   ");
    for(int i = 0; i < vertices.size(); i++)
    {
      sb.append(vertices.get(i).name + " ");
    }
    sb.append("\n");
    for(int i=0; i< vertices.size(); i++)
    {
      sb.append(vertices.get(i).name + "  ");
      for(int j: adjacencyMatrix[i])
      {
        sb.append((j) + " ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}