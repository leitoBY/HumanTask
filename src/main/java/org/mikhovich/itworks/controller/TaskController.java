package org.mikhovich.itworks.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.mikhovich.itworks.model.Task;
import org.mikhovich.itworks.service.TaskService;
import org.mikhovich.itworks.service.TaskServiceImpl;

public class TaskController {

	private TaskService taskService = new TaskServiceImpl();
	private ObservableList<Task> taskList = FXCollections.observableArrayList();
	
	public void addTask(Task task) {
		taskService.addTask(task);
	}
	
	public void updateTask(Task task) {
		taskService.updateTask(task);
	}
	
	public void deleteTask(int taskId) {
		taskService.deleteTask(taskId);
	}
	
	public ObservableList<Task> getTasksList() {
		if(!taskList.isEmpty()) {
			taskList.clear();
		}
		taskList = FXCollections.observableList((List<Task>) taskService.getAllTasks());
		return taskList;	
	}


	
}
