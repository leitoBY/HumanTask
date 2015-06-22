package org.mikhovich.itworks.general;

import org.mikhovich.itworks.controller.TaskController;
import org.mikhovich.itworks.model.Task;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	public GreateStage2() {
		
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
		grid2.setHgap(20);
		grid2.setVgap(2);
		
		grid2.add(new Label(label2[0]+":"), 1, 0);
		textField2[0] = new TextField();
		textField2[0].setEditable(false);
		textField2[0].setText("#human");
		grid2.add(textField2[0], 2, 0);
		
		grid2.add(new Label(label2[1]+":"), 1, 1);
		textField2[1] = new TextField();
		textField2[1].setPromptText("task");
		grid2.add(textField2[1], 2, 1);
		
		
		grid2.add(new Label(label2[2]+":"), 1, 2);
		st.setText("done");
		grid2.add(st, 2, 2);
		
		grid2.add(taskadd, 2, 3);
		taskadd.setOnAction(e->add2ButtonClicked());
		
		
		
		
		Stage stage = new Stage();
		stage.setTitle("Add new Task");
		stage.setScene(new Scene(grid2, 300, 200));
		stage.show();
	}
	public void add2ButtonClicked() {
		Task t= new Task(textField2[1].getText(), st.isSelected());
		
		tController.addTask(t);
	}
}
