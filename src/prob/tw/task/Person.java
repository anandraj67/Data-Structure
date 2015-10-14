package prob.tw.task;

import java.util.List;

public class Person {
	private String name;
	List<JobEfficiency> jobEfficiencyList ; 	
	public Person(String name,List<JobEfficiency> jobEfficiencyList) {
		this.name = name;
		this.jobEfficiencyList = jobEfficiencyList;
	}

	public String getName() {
		return name;
	}

	public List<JobEfficiency> getJobEfficiencyList() {
		return jobEfficiencyList;
	}
	
	public double calculateTimeReq()
	{
		double timeReq=0;
		for( JobEfficiency jobEfficiency : this.jobEfficiencyList )
		{
			timeReq += jobEfficiency.calculateTimeForJob(); 
		}
		return timeReq;
	}


}
