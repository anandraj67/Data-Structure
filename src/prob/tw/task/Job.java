package prob.tw.task;

public class Job {
	private String name;
	private int unitOfWork;

	public String getName() {
		return name;
	}

	public int getUnitOfWork() {
		return unitOfWork;
	}

	public Job(String name,int unitOfWork) {
		super();
		this.unitOfWork = unitOfWork;
		this.name = name;
	}
}
