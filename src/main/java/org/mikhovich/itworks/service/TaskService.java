package org.mikhovich.itworks.service;

import java.util.List;

import org.mikhovich.itworks.model.Task;

public interface TaskService {
	public void addTask(Task task);
	public void updateTask(Task task);
	public List<Task> getAllTasks();
	public void deleteTask(int taskId);
	public List<Task> gelAllHumanTasks(int id);

}
