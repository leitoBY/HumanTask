package org.mikhovich.itworks.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.mikhovich.itworks.model.Human;
import org.mikhovich.itworks.model.Log;
import org.mikhovich.itworks.util.HibernateUtil;

public class LogDAOImpl implements LogDAO {

	public void addLog(Log log) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			session.save(log);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}

	public void updateLog(Log log) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			session.update(log);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}

	public List<Log> getAlLogs() {
		List<Log> logs = new ArrayList<Log>();
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			logs = session.createQuery("from Log").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}	
		return logs;
	}

	public void deleteLog(int logId) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			Log l = (Log) session.load(Log.class, logId);
			session.delete(l);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}

}
