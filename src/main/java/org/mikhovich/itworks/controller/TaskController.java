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
	private ObservableList<Task> taskList2 = FXCollections.observableArrayList();
	
	
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
	
	public ObservableList<Task> getHumanTasksList(int id) {
		if(!taskList2.isEmpty()) {
			taskList2.clear();
		}
		taskList2 = FXCollections.observableList((List<Task>) taskService.gelAllHumanTasks(id));
		return taskList2;	
	}
	

	
}
