package org.mikhovich.itworks.general;

import java.util.ArrayList;
import java.util.List;

import org.mikhovich.itworks.controller.LogController;
import org.mikhovich.itworks.controller.TaskController;
import org.mikhovich.itworks.model.Log;
import org.mikhovich.itworks.model.Task;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreateStage3 {
	private String label3[] = {"Task", "Time", "Comment"};
	private TextField textField3[] = new TextField[2];
	private TextArea textArea = new TextArea();
	private Button logAdd = new Button("add Log");
	private LogController lController = new LogController();
	private TaskController tController = new TaskController();
	private ComboBox<Task> comboBox = new ComboBox<Task>();
	
	public GreateStage3() {
		
		GridPane grid3 = new GridPane();
		List<Task> selectList = new ArrayList<Task>();
		selectList = tController.getTasksList();
		for(Task t: selectList) {
			comboBox.getItems().add(t);
		}
		
		grid3.setPadding(new Insets(10, 10, 10, 10));
		grid3.setHgap(20);
		grid3.setVgap(2);
		
		grid3.add(new Label(label3[0]+":"), 1, 0);
		grid3.add(comboBox, 2, 0);
		
		grid3.add(new Label(label3[1]+":"), 1, 1);
		textField3[1] = new TextField();
		textField3[1].setPromptText("time");
		grid3.add(textField3[1], 2, 1);
		
		grid3.add(new Label(label3[2]+":"), 1, 2);
		textArea.setMaxSize(150, 130);
		textArea.setPromptText("add comment here...");
		grid3.add(textArea, 2, 2);
		
		grid3.add(logAdd, 2, 3);
		logAdd.setOnAction(new ButtonHandler());
				
		Stage stage3 = new Stage();
		stage3.setTitle("Add new Log");
		stage3.setScene(new Scene(grid3, 300, 200));
		stage3.show();
		
	}

	
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			
			Log l= new Log(Integer.parseInt(textField3[1].getText()), textArea.getText());
			l.setTask(comboBox.getValue());
			lController.addLog(l);
			
			Node  source = (Node)  e.getSource(); 
			Stage stage3  = (Stage) source.getScene().getWindow();
			stage3.close();
			
		}
	}
	

}
