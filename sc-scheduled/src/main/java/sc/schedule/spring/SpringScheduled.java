package sc.schedule.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringScheduled {

	// 每1分钟执行一次
	@Scheduled(cron = "0 */1 *  * * * ")
	public void reportCurrentByCron() {
		System.out.println("Spring Scheduling Tasks: " + dateFormat().format(new Date()));
	}

	private SimpleDateFormat dateFormat() {
		return new SimpleDateFormat("HH:mm:ss");
	}
}
