package as.Schedule;

import java.util.ArrayList;
import java.util.Iterator;

public class Schedule
{
	private ArrayList<Boolean> timeSlot=new ArrayList<Boolean>(24*7);
	public void setBusyTime(final int slot)
	{
		timeSlot.set(slot,true);
	}
	public Iterator<Integer> getSpaceTime()
	{
		ArrayList<Integer> temp=new ArrayList<Integer>();
		for(int i=0;i!=temp.size();++i)
			if(!timeSlot.get(i))
				temp.add(i);
		return temp.iterator();
	}
}