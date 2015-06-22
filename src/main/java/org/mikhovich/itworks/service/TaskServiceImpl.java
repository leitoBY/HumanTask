package org.mikhovich.itworks.service;

import java.util.List;

import org.mikhovich.itworks.dao.TaskDAO;
import org.mikhovich.itworks.dao.TaskDAOImpl;
import org.mikhovich.itworks.model.Task;

public class TaskServiceImpl implements TaskService {

	private TaskDAO taskDAO = new TaskDAOImpl();
	
	@Override
	public void addTask(Task task) {
		taskDAO.addTask(task);
	}

	@Override
	public void updateTask(Task task) {
		taskDAO.updateTask(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskDAO.getAllTasks();
	}

	@Override
	public void deleteTask(int taskId) {
		taskDAO.deleteTask(taskId);		
	}

}
