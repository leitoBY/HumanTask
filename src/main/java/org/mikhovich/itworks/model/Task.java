package org.mikhovich.itworks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Class Task */

@Entity
@Table(name ="Tasks")
public class Task {
	
	@Id
	@Column(name = "taskId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private String taskName;
	private boolean status;
	
	
	public Task() {
		super();
	}
	
	public Task(String taskName, boolean status) {
		super();
		this.taskName = taskName;
		this.status = status;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "humanId", nullable = true)
	
	private Human human;

	public Human getHuman() {
		return human;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="task")
	private List<Log> logList = new ArrayList<Log>();


	public List<Log> getLogList() {
		return logList;
	}
	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}

}
