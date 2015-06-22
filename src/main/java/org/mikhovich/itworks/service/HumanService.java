package org.mikhovich.itworks.service;

import java.util.List;
import org.mikhovich.itworks.model.Human;

public interface HumanService {
	public void addHuman(Human human);
	public void updateHuman(Human human);
	public List<Human> getAllHumans();
	public void deleteHuman(int id);

}
