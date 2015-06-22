package org.mikhovich.itworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Class Log */

@Entity
@Table(name = "Logs")
public class Log {

	@Id
	@Column(name = "logId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int logId;
	private int time;
	private String comment;
	
	
	public Log() {
		super();
	}
	
	public Log(int time, String comment) {
		super();
		this.time = time;
		this.comment = comment;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "taskId", nullable = true)
	
	private Task task;
	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
	
	
}
