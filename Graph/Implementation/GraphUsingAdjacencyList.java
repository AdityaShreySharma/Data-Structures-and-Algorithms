import java.util.*;
public class GraphUsingAdjacencyList
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
  ArrayList<Node> neighbors = new ArrayList<Node>();

  public Node(String name, int index)
  {
    this.name = name;
    this.index = index;
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

  public String toString() 
  {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<vertices.size(); i++) 
    {
      sb.append(vertices.get(i).name + "  ");
      for(int j=0; j<vertices.get(i).neighbors.size(); j++) 
      {
        if(j == vertices.get(i).neighbors.size() - 1 ) 
        {
          sb.append((vertices.get(i).neighbors.get(j).name) );
        } 
        else 
        {
          sb.append((vertices.get(i).neighbors.get(j).name) + " -> ");
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}