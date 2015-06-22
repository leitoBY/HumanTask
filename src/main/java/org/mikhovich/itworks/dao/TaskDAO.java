package org.mikhovich.itworks.dao;

import java.util.List;

import org.mikhovich.itworks.model.Task;

public interface TaskDAO {
	
	public void addTask(Task task);
	public void updateTask(Task task);
	public List<Task> getAllTasks();
	public void deleteTask(int taskId);

}
