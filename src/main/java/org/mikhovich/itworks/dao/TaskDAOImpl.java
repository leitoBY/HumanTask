package org.mikhovich.itworks.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.mikhovich.itworks.model.Human;
import org.mikhovich.itworks.model.Task;
import org.mikhovich.itworks.util.HibernateUtil;

public class TaskDAOImpl implements TaskDAO {

	public void addTask(Task task) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			session.save(task);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}

	public void updateTask(Task task) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			session.update(task);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}

	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			tasks = session.createQuery("from Task").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}	
		return tasks;
	}

	public void deleteTask(int taskId) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			Task t = (Task) session.load(Task.class, taskId);
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
			
	}

}
