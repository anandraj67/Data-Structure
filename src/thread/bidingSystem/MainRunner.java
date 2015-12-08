package thread.bidingSystem;

import java.util.LinkedList;
import java.util.Queue;

public class MainRunner {
	public static void main(String[] args) {
		for (int i=0;i<20;i++)
			new User().startActivities();
	}

}
