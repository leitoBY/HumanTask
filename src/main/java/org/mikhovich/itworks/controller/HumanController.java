package org.mikhovich.itworks.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.mikhovich.itworks.model.Human;
import org.mikhovich.itworks.service.HumanService;
import org.mikhovich.itworks.service.HumanServiceImpl;

public class HumanController {
	private HumanService humanService = new HumanServiceImpl();
	private ObservableList<Human> humanList = FXCollections.observableArrayList();
	
	public void addHuman(Human human) {
		humanService.addHuman(human);
	}
	
	public void updateHuman(Human human) {
		humanService.updateHuman(human);
	}
	
	public void deleteHuman(int id) {
		humanService.deleteHuman(id);
	}
	
	public ObservableList<Human> getHumanList() {
		if(!humanList.isEmpty()) {
			humanList.clear();
		}
		humanList = FXCollections.observableList((List<Human>) humanService.getAllHumans());
		return humanList;	
	}
}
