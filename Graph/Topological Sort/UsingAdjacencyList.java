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

  public void addDirectedEdge(int i, int j)
  {
    Node first = vertices.get(i);
    Node second = vertices.get(j);
    first.neighbors.add(second);
  }

  void visitNodes(Node node, Stack<Node> stack)
  {
    for(Node neighbor : node.neighbors)
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
    for(int i=0; i<vertices.size(); i++) 
    {
      sb.append(vertices.get(i).name + "  ");
      for(int j=0; j<vertices.get(i).neighbors.size(); j++) 
      {
        if(j == vertices.get(i).neighbors.size() - 1 ) 
        {
          sb.append((vertices.get(i).neighbors.get(j).name));
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