package org.mikhovich.itworks.general;

import org.mikhovich.itworks.dao.HumanDAO;
import org.mikhovich.itworks.dao.HumanDAOImpl;

public class Factory {
	public static Factory instance = new Factory();
	public HumanDAO humanDAO;
	
	private Factory() {}
	
	public static Factory getInstance() {
		return Factory.instance;
	}
	
	public HumanDAO getHumanDAO() {
		if (humanDAO == null) humanDAO = new HumanDAOImpl();
		return humanDAO;
		
	
		
	}

}
