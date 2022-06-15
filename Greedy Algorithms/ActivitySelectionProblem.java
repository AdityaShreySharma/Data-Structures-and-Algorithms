import java.util.*;
public class ActivitySelectionProblem
{
  public static void main(String args[])
  {
    ArrayList<Activity> activityList = new ArrayList<Activity>();

    activityList.add(new Activity("A1", 0, 6));
    activityList.add(new Activity("A2", 3, 4));
    activityList.add(new Activity("A3", 1, 2));
    activityList.add(new Activity("A4", 5, 8));
    activityList.add(new Activity("A5", 5, 7));
    activityList.add(new Activity("A6", 8, 9));

    ActivitySelection as = new ActivitySelection();

    as.activitySelection(activityList);
  }
}

class Activity
{
  String name;
  int startTime;
  int finishTime;

  public Activity(String name, int startTime, int finishTime)
  {
    this.name = name;
    this.startTime = startTime;
    this.finishTime = finishTime;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getStartTime()
  {
    return startTime;
  }
  
  public void setStartTime(int startTime)
  {
    this.startTime = startTime;
  }

  public int getFinishTime()
  {
    return finishTime;
  }
  
  public void setFinishTime(int finishTime)
  {
    this.finishTime = finishTime;
  }

  @Override
  public String toString()
  {
    return "Activity " + name + ", Start Time = " + startTime + ", Finish Time = " + finishTime;
  }
}

class ActivitySelection
{
  public void activitySelection(ArrayList<Activity> activityList)
  {
    Comparator<Activity> finishTimeComparator = new Comparator<Activity>()
    {
      @Override
      public int compare(Activity a1, Activity a2)
      {
        return a1.getFinishTime() - a2.getFinishTime();
      }
    };
    Collections.sort(activityList, finishTimeComparator);
    Activity previousActivity = activityList.get(0);

    System.out.println("Recommended Activities :- \n" + activityList.get(0));

    for(int i=1; i<activityList.size(); i++)
    {
      Activity currentActivity = activityList.get(i);
      if(currentActivity.getStartTime() >= previousActivity.getFinishTime())
      {
        System.out.println(currentActivity);
        previousActivity = currentActivity;
      }
    }
  }
}