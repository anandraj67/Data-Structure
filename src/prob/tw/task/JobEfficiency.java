package prob.tw.task;

public class JobEfficiency {
	Job job;
	double efficiencyOfWork;
	public JobEfficiency(Job job, double efficiencyOfWork) {
		this.job = job;
		this.efficiencyOfWork = efficiencyOfWork;
	}
	public Job getJob() {
		return job;
	}
	public double getEfficiencyOfWork() {
		return efficiencyOfWork;
	}
	
	public double calculateTimeForJob()
	{
		return ( 1 / (efficiencyOfWork * job.getUnitOfWork()));
	}
	


}
