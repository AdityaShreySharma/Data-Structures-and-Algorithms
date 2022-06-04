import java.util.*;
public class AnimalShelter
{
  public static void main(String[] args)
  {
    Queue q = new Queue();

    q.enQueue(new Cat("Jenny"));
    q.enQueue(new Cat("Kiki"));
    q.enQueue(new Dog("Victor"));
    q.enQueue(new Cat("Snowbell"));
    q.enQueue(new Dog("Scooby"));

    System.out.println(q.deQueueAny().name());
    System.out.println(q.deQueueDog().name());
    System.out.println(q.deQueueCat().name());
  }
}

abstract class Animal
{
  int order;
  String name;
  
  public Animal(String n)
  {
    this.name = n;
  }

  public abstract String name();

  public void setOrder(int ord)
  {
    this.order = ord;
  }

  public int getOrder()
  {
    return order;
  }

  public boolean isOlderThan(Animal a)
  {
    return this.order < a.getOrder();
  }
}

class Cat extends Animal
{
  public Cat(String n)
  {
    super(n);
  }

  public String name()
  {
    return "Cat - " + name;
  }
}

class Dog extends Animal
{
  public Dog(String n)
  {
    super(n);
  }

  public String name()
  {
    return "Dog - " + name;
  }
}

class Queue
{
  LinkedList<Dog> dogs = new LinkedList<Dog>();
  LinkedList<Cat> cats = new LinkedList<Cat>();
  int order = 0;

  public void enQueue(Animal a)
  {
    a.setOrder(order);
    order++;
    if(a instanceof Dog)
    {
      dogs.addLast((Dog) a);
    }
    else if(a instanceof Cat)
    {
      cats.addLast((Cat) a);
    }
  }

  public int size()
  {
    return dogs.size() + cats.size();
  }

  public Dog deQueueDog()
  {
    return dogs.poll();
  }

  public Dog peekDog()
  {
    return dogs.peek();
  }

  public Cat deQueueCat()
  {
    return cats.poll();
  }

  public Cat peekCat()
  {
    return cats.peek();
  }

  public Animal deQueueAny()
  {
    if(dogs.size() == 0)
    {
      return deQueueCat();
    }
    else if(cats.size() == 0)
    {
      return deQueueDog();
    }
    else
    {
      Dog dog = dogs.peek();
      Cat cat = cats.peek();

      if(dog.isOlderThan(cat))
      {
        return dogs.poll();
      }
      else
      {
        return cats.poll();
      }
    }
  }

  public Animal peekAnimal()
  {
    if(dogs.size() == 0)
    {
      return cats.peek();
    }
    else if(cats.size() == 0)
    {
      return dogs.peek();
    }
    else
    {
      Dog dog = dogs.peek();
      Cat cat = cats.peek();

      if(dog.isOlderThan(cat))
      {
        return dogs.peek();
      }
      else
      {
        return cats.peek();
      }
    }
  }
}