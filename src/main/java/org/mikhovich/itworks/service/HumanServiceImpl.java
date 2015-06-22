package org.mikhovich.itworks.service;

import java.util.List;

import org.mikhovich.itworks.dao.HumanDAO;
import org.mikhovich.itworks.dao.HumanDAOImpl;
import org.mikhovich.itworks.model.Human;

public class HumanServiceImpl implements HumanService {

	private HumanDAO humanDAO = new HumanDAOImpl();
	
	@Override
	public void addHuman(Human human) {
		humanDAO.addHuman(human);
	}

	@Override
	public void updateHuman(Human human) {
		humanDAO.updateHuman(human);
	}

	@Override
	public List<Human> getAllHumans() {
		return humanDAO.getAllHumans();
	}

	@Override
	public void deleteHuman(int id) {
		humanDAO.deleteHuman(id);
	}
	
}
