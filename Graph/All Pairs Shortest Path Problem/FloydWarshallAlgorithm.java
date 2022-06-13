import java.util.*;
public class FloydWarshallAlgorithm
{
  public static void main(String args[])
  {
    ArrayList<Node> vertices = new ArrayList<Node>();

    // Refer Graph 2.PNG
    vertices.add(new Node("A", 0));
    vertices.add(new Node("B", 1));
    vertices.add(new Node("C", 2));
    vertices.add(new Node("D", 3));

    Graph graph = new Graph(vertices);

    graph.addWeightedEdge(0, 3, 1);
    graph.addWeightedEdge(0, 1, 8);
    graph.addWeightedEdge(1, 2, 1);
    graph.addWeightedEdge(2, 0, 4);
    graph.addWeightedEdge(3, 1, 2);
    graph.addWeightedEdge(3, 2, 9);

    graph.FloydWarshall();
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

  public void FloydWarshall()
  {
    int size = vertices.size();
    int V[][] = new int[size][size];
    for(int i=0; i<size; i++)
    {
      Node first = vertices.get(i);
      for(int j=0; j<size; j++)
      {
        Node second = vertices.get(j);
        if(i == j)
        {
          V[i][j] = 0;
        }
        else if(first.weights.containsKey(second))
        {
          V[i][j] = first.weights.get(second);
        }
        else
        {
          V[i][j] = Integer.MAX_VALUE / 10;
        }
      }
    }

    for(int k=0; k<vertices.size(); k++)
    {
      for(int i=0; i<vertices.size(); i++)
      {
        for(int j=0; j<vertices.size(); j++)
        {
          if(V[i][j] > V[i][k] + V[k][j])
          {
            V[i][j] = V[i][k] + V[k][j];
          }
        }
      }
    }

    for(int i=0; i<size; i++)
    {
      if(i == 0)
      {
        System.out.print("  " + vertices.get(i) + " ");
      }
      else
      {
        System.out.print(vertices.get(i) + " ");
      }
    }
    System.out.println(" ");

    for(int i=0; i<size; i++)
    {
      System.out.print(vertices.get(i) + " ");
      for(int j=0; j<size; j++)
      {
        System.out.print(V[i][j] + " ");
      }
      System.out.println(" ");
    }
  }
}