package prob.tw.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainRunner {

	public static Person solution(List<Person> personList )
	{
		double bestTimeReq = Double.MAX_VALUE;
		Person bestPerson = null;
		for(Person person : personList)
		{
			double timeReq = person.calculateTimeReq();
			if(timeReq < bestTimeReq)
			{
				bestTimeReq = timeReq;
				bestPerson = person;
			}
		}
		return bestPerson;
	}
	public static void main(String[] args) {
		Job carpentryJob = new Job("Carpentry",8);
		Job paintingJob = new Job("Painting",5);
		
		JobEfficiency je1 = new JobEfficiency(carpentryJob, .1); 
		JobEfficiency je2 = new JobEfficiency(paintingJob, .5);
		
		
		JobEfficiency je3 = new JobEfficiency(carpentryJob, .65);
		JobEfficiency je4 = new JobEfficiency(paintingJob, .3);
		
		Person p1 = new Person("A", Arrays.asList(je1,je2));
		Person p2 = new Person("B", Arrays.asList(je3,je4));
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(p1);
		personList.add(p2);
		
		Person bestPerson = solution(personList);
		System.out.println(bestPerson.getName() + " is the best person for this job");
		
	}

}
