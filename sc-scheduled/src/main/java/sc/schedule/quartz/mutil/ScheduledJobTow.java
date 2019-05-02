package sc.schedule.quartz.mutil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ScheduledJobTow implements Job {

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}

	@Override
	public void execute(JobExecutionContext cxt) throws JobExecutionException {
		System.out.println("quartz ScheduledJobTow Tasks: " + dateFormat().format(new Date()));
		System.out.println("name = " + cxt.getJobDetail().getJobDataMap().getString("name"));
	}

}
