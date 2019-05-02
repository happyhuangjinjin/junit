package com.cto51;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cto51.dto.SaleDetail;
import com.cto51.dto.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrlTest {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	public ProcessInstance deploy() {
		repositoryService.createDeployment().addClasspathResource("com/cto51/Sale.drl")
				.addClasspathResource("com/cto51/Sale.bpmn").deploy();
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("sale");
		return pi;
	}

	// 符合周六日打九折条件
	@Test
	public void discount90() {
		ProcessInstance pi = deploy();
		SaleDetail s1 = new SaleDetail("001", createDate("2019-02-16"));
		Product s1Item1 = new Product("果粒橙", 8.0f, 4);
		s1.addProduct(s1Item1);
		Product s1Item2 = new Product("苹果", 5.0f, 4);
		s1.addProduct(s1Item2);
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("sale", s1);
		// 查找任务
		Task task = taskService.createTaskQuery().processDefinitionId(pi.getProcessDefinitionId()).singleResult();
		taskService.complete(task.getId(), vars);
	}

	// 根据字符串创建日期对象
	public Date createDate(String date) {
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			throw new RuntimeException("parse date error: " + e.getMessage());
		}
	}

	// 满500打八折
	@Test
	public void discount80() {
		ProcessInstance pi = deploy();
		SaleDetail s1 = new SaleDetail("001", createDate("2019-02-18"));
		Product s1Item1 = new Product("电冰箱", 600f, 1);
		s1.addProduct(s1Item1);
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("sale", s1);
		// 查找任务
		Task task = taskService.createTaskQuery().processDefinitionId(pi.getProcessDefinitionId()).singleResult();
		taskService.complete(task.getId(), vars);
	}

	// 满1000打七折
	@Test
	public void discount70() {
		ProcessInstance pi = deploy();
		SaleDetail s1 = new SaleDetail("001", createDate("2019-02-18"));
		Product s1Item1 = new Product("苹果手机", 8888.0f, 4);
		s1.addProduct(s1Item1);
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("sale", s1);
		// 查找任务
		Task task = taskService.createTaskQuery().processDefinitionId(pi.getProcessDefinitionId()).singleResult();
		taskService.complete(task.getId(), vars);
	}

	// 星期天满1000
	@Test
	public void discountOther() {
		ProcessInstance pi = deploy();
		SaleDetail s1 = new SaleDetail("001", createDate("2019-02-23"));
		Product s1Item1 = new Product("苹果手机", 8888.0f, 4);
		s1.addProduct(s1Item1);
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("sale", s1);
		// 查找任务
		Task task = taskService.createTaskQuery().processDefinitionId(pi.getProcessDefinitionId()).singleResult();
		taskService.complete(task.getId(), vars);
	}

}
