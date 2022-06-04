import java.util.*;
public class BasicTree
{
  public static void main(String[] args)
  {
    Tree drinks = new Tree("Drinks");
    Tree hot = new Tree("Hot"); 
    Tree cold = new Tree("Cold");
    Tree tea = new Tree("Tea"); 
    Tree coffee = new Tree("Coffee");
    Tree pepsi = new Tree("Pepsi");
    Tree sprite = new Tree("Sprite");
    
    drinks.addChild(hot);
    drinks.addChild(cold);
    hot.addChild(tea);
    hot.addChild(coffee);
    cold.addChild(pepsi);
    cold.addChild(sprite);

    System.out.println(drinks.print(0));
  }
}

class Tree 
{
  String value;
  ArrayList<Tree> children;

  public Tree(String value)
  {
    this.value = value;
    this.children = new ArrayList<Tree>();
  }

  public void addChild(Tree node)
  {
    this.children.add(node);
  }

  public String print(int level)
  {
    String result;
    result = " ".repeat(level) + value + "\n";
    for(Tree node: this.children)
    {
      result += node.print(level + 1);
    }
    return result;
  }
}