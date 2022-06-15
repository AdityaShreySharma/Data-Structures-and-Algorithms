import java.util.*;
public class FractionalKnapsackProblem
{
  public static void main(String[] args)
  {
    ArrayList<Knapsack> items = new ArrayList<Knapsack>();

    int values[] = {100, 120, 60};
    int weights[] = {20, 30, 10};
    int capacity = 50;
    for(int i=0; i<values.length; i++)
    {
      items.add(new Knapsack(i+1, values[i], weights[i]));
    }

    FractionalKnapsack fk = new FractionalKnapsack();
    fk.knapsack(items, capacity);
  }
}

class Knapsack
{
  int index;
  int value;
  int weight;
  double ratio;

  public Knapsack(int index, int value, int weight)
  {
    this.index = index;
    this.value = value;
    this.weight = weight;
    this.ratio = (value * 1.0) / weight;
  }

  public int getIndex()
  {
    return index;
  }

  public void setIndex(int index)
  {
    this.index = index;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int value)
  {
    this.value = value;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  { 
    this.weight = weight; 
  }

  public double getRatio() 
  {
    return ratio;
  }

  public void setRatio(double ratio)
  {
    this.ratio = ratio;
  }

  @Override
  public String toString()
  {
    return "Index = " + index + ", Value = " + value + ", Weight = " + weight + ", Ratio = " + ratio;
  }
}

class FractionalKnapsack
{
  public void knapsack(ArrayList<Knapsack> items, int capacity)
  {
    Comparator<Knapsack> comparator = new Comparator<Knapsack>()
    {
      @Override
      public int compare(Knapsack k1, Knapsack k2)
      {
        if(k2.getRatio() > k1.getRatio())
        { 
          return 1; 
        }
        else
        {
          return -1;
        }
      }
    };
    Collections.sort(items, comparator);
    int usedCapacity = 0;
    double totalValue = 0;

    for(Knapsack item: items) 
    {
      if(usedCapacity + item.getWeight() <= capacity)
      {
        usedCapacity += item.getWeight();
        System.out.println(item);
        totalValue += item.getValue();
      }
      else
      {
        int usedWeight = capacity - usedCapacity;
        double value = item.getRatio() * usedWeight;
        System.out.println("Index = " + item.getIndex() + ", Obtained Value = " + value + ", Used Weight = " + usedWeight + ", Ratio = " + item.getRatio());
        usedCapacity += usedWeight;
        totalValue += value;
      }
      
      if(usedCapacity == capacity) 
      {
        break;
      }
    }
    System.out.println("Total Value Obtained = " + totalValue);
  }
}