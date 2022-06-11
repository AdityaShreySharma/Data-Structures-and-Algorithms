import java.util.*;
public class DepthFirstSearch
{
  public static void main(String[] args)
  {
    ArrayList<Node> vertices = new ArrayList<Node>();

    vertices.add(new Node("A", 0));
    vertices.add(new Node("B", 1));
    vertices.add(new Node("C", 2));
    vertices.add(new Node("D", 3));
    vertices.add(new Node("E", 4));

    Graph graph = new Graph(vertices);

    graph.addUndirectedEdge(0, 1);
    graph.addUndirectedEdge(0, 2);
    graph.addUndirectedEdge(0, 3);
    graph.addUndirectedEdge(1, 4);
    graph.addUndirectedEdge(2, 3);
    graph.addUndirectedEdge(3, 4);

    System.out.println(" ");
    System.out.println(graph.toString());

    System.out.print("DFS Traversal - ");
    graph.DFS();
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

  public void addUndirectedEdge(int i, int j)
  {
    adjacencyMatrix[i][j] = 1;
    adjacencyMatrix[j][i] = 1;
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

  public void visitNodes(Node node)
  {
    Stack<Node> stack = new Stack<Node>();
    stack.push(node);
    while(!stack.isEmpty())
    {
      Node currentNode = stack.pop();
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<Node> neighbors = getNeighbors(currentNode);
      for(Node neighbor: neighbors)
      {
        if(!neighbor.isVisited)
        {
          stack.push(neighbor);
          neighbor.isVisited = true;
        }
      }
    }
  }

  public void DFS()
  {
    for(Node node: vertices)
    {
      if(!node.isVisited)
      {
        visitNodes(node);
      }
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