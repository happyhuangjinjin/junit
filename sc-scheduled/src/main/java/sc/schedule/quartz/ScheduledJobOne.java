package sc.schedule.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledJobOne {

	public void execute() {
		System.out.println("quartz ScheduledJobOne Tasks: " + dateFormat().format(new Date()));
	}

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}

}
