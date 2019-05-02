package sc.ad.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
 
public class DroolsService implements JavaDelegate
{

	@Override
	public void execute(DelegateExecution execution) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(execution.getVariable("reason"));
		System.out.println("++++++++++++++++++++++++++++++++++++++");
	}
	
}
