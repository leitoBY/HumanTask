package org.mikhovich.itworks.general;

import java.util.ArrayList;
import java.util.List;

import org.mikhovich.itworks.controller.HumanController;
import org.mikhovich.itworks.controller.TaskController;
import org.mikhovich.itworks.model.Human;
import org.mikhovich.itworks.model.Task;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreateStage2 {
	private String label2[] = {"Human", "Task", "status"};
	private TextField textField2[] = new TextField[3];
	private RadioButton st = new RadioButton();
	private Button taskadd = new Button("add Task");
	private TaskController tController = new TaskController();
	private HumanController hController = new HumanController();
	private ComboBox<Human> comboBox = new ComboBox<Human>();
	
	
	
	public GreateStage2() {
		List<Human> selectList = new ArrayList<Human>();
		selectList = hController.getHumanList();
		for (Human h: selectList) {
			comboBox.getItems().add(h);
		}
		
		
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
		grid2.setHgap(20);
		grid2.setVgap(2);
		
		
		
		grid2.add(new Label(label2[0]+":"), 1, 0);
		grid2.add(comboBox, 2, 0);
		
		
		grid2.add(new Label(label2[1]+":"), 1, 1);
		textField2[1] = new TextField();
		textField2[1].setPromptText("task");
		grid2.add(textField2[1], 2, 1);
		
		
		grid2.add(new Label(label2[2]+":"), 1, 2);
		st.setText("done");
		grid2.add(st, 2, 2);
		
		grid2.add(taskadd, 2, 3);
		taskadd.setOnAction(new ButtonHandler());
		
		
		
		
		Stage stage2 = new Stage();
		stage2.setTitle("Add new Task");
		stage2.setScene(new Scene(grid2, 300, 200));
		stage2.show();
	}

	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			
			Task t= new Task(textField2[1].getText(), st.isSelected());
			t.setHuman(comboBox.getValue());
			tController.addTask(t);
			
			Node  source = (Node)  e.getSource(); 
			Stage stage2  = (Stage) source.getScene().getWindow();
			stage2.close();
			
		}
	}
}
