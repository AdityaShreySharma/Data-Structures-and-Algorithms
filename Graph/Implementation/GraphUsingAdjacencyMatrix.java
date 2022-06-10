import java.util.*;
public class GraphUsingAdjacencyMatrix
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

    Graph graph = new Graph(vertices);

    graph.addUndirectedEdge(0, 1);
    graph.addUndirectedEdge(0, 2);
    graph.addUndirectedEdge(0, 3);
    graph.addUndirectedEdge(1, 4);
    graph.addUndirectedEdge(2, 3);
    graph.addUndirectedEdge(3, 4);

    System.out.println(graph.toString());
  }
}

class Node
{
  String name;
  int index;

  public Node(String name, int index)
  {
    this.name = name;
    this.index = index;
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