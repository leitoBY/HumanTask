package org.mikhovich.itworks.dao;

import java.util.List;

import org.mikhovich.itworks.model.Log;



public interface LogDAO {
	
	public void addLog(Log log);
	public void updateLog(Log log);
	public List<Log> getAllLogs();
	public void deleteLog(int logId);
	public List<Log> getAllTaskLogs(int taskId);

}
