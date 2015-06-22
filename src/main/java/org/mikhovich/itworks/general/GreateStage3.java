package org.mikhovich.itworks.general;

import org.mikhovich.itworks.controller.LogController;
import org.mikhovich.itworks.model.Log;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	public GreateStage3() {
		
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(10, 10, 10, 10));
		grid3.setHgap(20);
		grid3.setVgap(2);
		
		grid3.add(new Label(label3[0]+":"), 1, 0);
		textField3[0] = new TextField();
		textField3[0].setEditable(false);
		textField3[0].setText("#task");
		grid3.add(textField3[0], 2, 0);
		
		grid3.add(new Label(label3[1]+":"), 1, 1);
		textField3[1] = new TextField();
		textField3[1].setPromptText("time");
		grid3.add(textField3[1], 2, 1);
		
		
		grid3.add(new Label(label3[2]+":"), 1, 2);
		textArea.setMaxSize(150, 130);
		textArea.setPromptText("add comment here...");
		grid3.add(textArea, 2, 2);

		
		grid3.add(logAdd, 2, 3);
		logAdd.setOnAction(e->addButtonClicked());
		
		
		
		
		
		Stage stage2 = new Stage();
		stage2.setTitle("Add new Log");
		stage2.setScene(new Scene(grid3, 300, 200));
		stage2.show();
	}


	public void addButtonClicked() {
		Log l= new Log(Integer.parseInt(textField3[1].getText()), textArea.getText());
		
		lController.addLog(l);
		
	}
	
}
