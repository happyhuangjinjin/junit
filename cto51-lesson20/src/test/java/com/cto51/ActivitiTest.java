package com.cto51;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;

	@Test
	public void deployTest() {
		// 根据bpmn文件部署流程
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("holiday.bpmn").deploy();
		log.info("deployment id : {}", deployment.getId());
	}

	@Test
	public void getProcessDefinitionTest() {
		// 获取流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()//
				.processDefinitionKey("holiday").singleResult();
		log.info("processDefinition id : {}", processDefinition.getId());
		log.info("deployment id : {}", processDefinition.getDeploymentId());
	}

	@Test
	public void startProcessDefinitionTest() {
		// 启动流程定义，返回流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("holiday");
		log.info("流程创建成功，当前流程实例ID：" + pi.getId());
	}
	
	
	@Test
	public void runTaskTest() {
		Task task = taskService.createTaskQuery().processDefinitionKey("holiday")
				.singleResult();
		log.info("第一次执行前，任务名称：" + task.getName());
		taskService.complete(task.getId());
		
		task = taskService.createTaskQuery().processDefinitionKey("holiday")
				.singleResult();
		log.info("第二次执行前，任务名称：" + task.getName());
		taskService.complete(task.getId());

		task = taskService.createTaskQuery().processDefinitionKey("holiday")
				.singleResult();
		log.info("第三次执行前，任务名称：" + task.getName());
		taskService.complete(task.getId());
		
		task = taskService.createTaskQuery().processDefinitionKey("holiday")
				.singleResult();
		log.info("task为null，任务执行完毕：" + task);
	}
}
