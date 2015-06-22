package org.mikhovich.itworks.service;

import java.util.List;

import org.mikhovich.itworks.dao.LogDAO;
import org.mikhovich.itworks.dao.LogDAOImpl;
import org.mikhovich.itworks.model.Log;

public class LogServiceImpl implements LogService {

	private LogDAO logDAO = new LogDAOImpl();
	
	@Override
	public void addLog(Log log) {
		logDAO.addLog(log);	
	}

	@Override
	public void updateLog(Log log) {
		logDAO.updateLog(log);
	}

	@Override
	public List<Log> getAllLogs() {
		return logDAO.getAlLogs();
	}

	@Override
	public void deleteLog(int logId) {
		logDAO.deleteLog(logId);
	}

}
