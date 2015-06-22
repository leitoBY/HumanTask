package org.mikhovich.itworks.dao;

import java.util.ArrayList;
import java.util.List;

import org.mikhovich.itworks.util.HibernateUtil;
import org.hibernate.Session;
import org.mikhovich.itworks.model.Human;


public class HumanDAOImpl implements HumanDAO {

	
	public void addHuman(Human human) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			session.save(human);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
	}

	public void updateHuman(Human human) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			session.update(human);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}
	
	public List<Human> getAllHumans() {
		List<Human> humans = new ArrayList<Human>();
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			humans = session.createQuery("from Human").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}	
		return humans;
	}

	public void deleteHuman(int id) {
		Session session = null;
		try {
			session = HibernateUtil.createSessionFactory().openSession();
			session.beginTransaction();
			Human h = (Human) session.load(Human.class, id);
			session.delete(h);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if ((session != null) && (session.isOpen()))session.close();  
		}
		
	}

}
