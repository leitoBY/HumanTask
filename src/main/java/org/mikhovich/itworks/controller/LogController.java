package org.mikhovich.itworks.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.mikhovich.itworks.model.Log;
import org.mikhovich.itworks.service.LogService;
import org.mikhovich.itworks.service.LogServiceImpl;

public class LogController {

	private LogService logService = new LogServiceImpl();
	private ObservableList<Log> logList = FXCollections.observableArrayList();
	
	public void addLog(Log log) {
		logService.addLog(log);
	}
	
	public void updateLog(Log log) {
		logService.updateLog(log);
	}
	
	public void deleteLog(int logId) {
		logService.deleteLog(logId);
	}
	
	public ObservableList<Log> getLogsList() {
		if(!logList.isEmpty()) {
			logList.clear();
		}
		logList = FXCollections.observableList((List<Log>) logService.getAllLogs());
		return logList;	
	}
	
}
