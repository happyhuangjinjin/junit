package sc.ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sc.ad.model.Leave;

@RestController
public class ADController {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

//	@RequestMapping("/ad")
//	public void ad() {
//
//		// 根据bpmn文件部署流程
//		Deployment deployment = repositoryService.createDeployment()
//				.addClasspathResource("holiday.bpmn").deploy();
//		// 获取流程定义
//		ProcessDefinition processDefinition = repositoryService
//				.createProcessDefinitionQuery()
//				.deploymentId(deployment.getId()).singleResult();
//		// 启动流程定义，返回流程实例
//		ProcessInstance pi = runtimeService
//				.startProcessInstanceById(processDefinition.getId());
//		String processId = pi.getId();
//		System.out.println("流程创建成功，当前流程实例ID：" + processId);
//
//		Task task = taskService.createTaskQuery().processInstanceId(processId)
//				.singleResult();
//		System.out.println("第一次执行前，任务名称：" + task.getName());
//		taskService.complete(task.getId());
//
//		task = taskService.createTaskQuery().processInstanceId(processId)
//				.singleResult();
//		System.out.println("第二次执行前，任务名称：" + task.getName());
//		taskService.complete(task.getId());
//
//		task = taskService.createTaskQuery().processInstanceId(processId)
//				.singleResult();
//		System.out.println("task为null，任务执行完毕：" + task);
//	}
	
	@RequestMapping("/drl")
	public void drl() {
    	/**
    	 * 注意这里：必须要把drl文件一起deploy
    	 */
    	DeploymentBuilder deploy = repositoryService.createDeployment();
    	deploy.addClasspathResource("leave.bpmn").addClasspathResource("leave.drl");
    	deploy.deploy();
    	ProcessInstance pi = runtimeService.startProcessInstanceByKey("leave");
    	Map<String, Object> vars = new HashMap<String, Object>();  
//        vars.put("leave", new Leave("白展堂", 12));
    	vars.put("leave", new Leave("乔峰", 2));
        /**
         * 当前任务
         */
    	List<Task> tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
    	for(Task task : tasks)
    	{
    		System.out.println(task.getId() + " , " + task.getName());
    		taskService.complete(task.getId(), vars);
    	}
    	/**
    	 * 下一步任务
    	 */
    	tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
    	for(Task task : tasks)
    	{
    		System.out.println(task.getId() + " , " + task.getName());
    	}
	}
}
