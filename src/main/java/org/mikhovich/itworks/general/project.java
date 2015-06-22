package org.mikhovich.itworks.general;

import java.sql.SQLException;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



import org.mikhovich.itworks.controller.HumanController;
import org.mikhovich.itworks.controller.LogController;
import org.mikhovich.itworks.controller.TaskController;
import org.mikhovich.itworks.model.Human;
import org.mikhovich.itworks.model.Log;
import org.mikhovich.itworks.model.Task;


public class project extends Application {
	private TableView<Human> table1 = new TableView<>();
	private TableView<Task> table2 = new TableView<>();
	private TableView<Log> table3 = new TableView<>();
	private String buttonCaption[] = {"Add new", "update", "delete", "clear", "add new task", "add new Log"};
	private String label[] = {"First Name", "Last Name", "Middle Name", "Login", "Password"};
	private Button button[] = new Button[6];
	private TextField textField[] = new TextField[5];
	private HumanController hController = new HumanController();
	private TaskController tController = new TaskController();
	private LogController lController = new LogController();
	
	

	public static void main(String[] args) throws SQLException{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Humans");
		BorderPane border = new BorderPane();
		
		border.setTop(createButtonBox());
		border.setLeft(table1);
		border.setCenter(table2);
		border.setRight(table3);
		border.setBottom(createForm());
		border.setPadding(new Insets(10, 10, 10, 10));
		populateTable();
		stage.setScene(new Scene(border, 850, 550));
		
		table1.setRowFactory( tv -> {
		    TableRow<Human> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		    	if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
		            Human rowData = row.getItem();
		            textField[0].setText(rowData.getFirstName());
		            textField[1].setText(rowData.getLastName());
		            textField[2].setText(rowData.getMiddleName());
		            textField[3].setText(rowData.getLogin());
		            textField[4].setText(rowData.getPassword());
		            populateTable2(rowData.getHumanId());
		        } 
		    });
		    return row ;
		});
		
		table2.setRowFactory( tv -> {
		    TableRow<Task> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		    	if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
		            Task rowData = row.getItem();
		            
		            populateTable3(rowData.getTaskId());
		        } 
		    });
		    return row ;
		});
		
		
		stage.show();
	}
	
	private Pane createForm() {
		GridPane grid = new GridPane();
		//grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setHgap(20);
		grid.setVgap(2);
		for(int i=0; i < label.length; i++) {
			grid.add(new Label(label[i]+":"), 1, i);
			textField[i] = new TextField();
			textField[i].setPromptText(label[i]);
			grid.add(textField[i], 2, i);
		}
		return grid;
	}
	
	private Pane createButtonBox() {
		int width = 100;
		HBox box = new HBox();
		//box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(10,10,10,10));
		box.setSpacing(5);
		for (int i = 0; i < buttonCaption.length; i++) {
			button[i] = new Button(buttonCaption[i]);
			button[i].setMinWidth(width);
			button[i].setOnAction(new ButtonHandler());
			box.getChildren().add(button[i]);
		}
		return box;
	}
	

	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			//add human
			if (event.getSource().equals(button[0])) {
				Human h = new Human(textField[0].getText(), textField[1].getText(), textField[2].getText(), 
						textField[3].getText(), textField[4].getText());
				hController.addHuman(h);
				for (int i = 0; i < label.length; i++) {
					textField[i].clear();
				
				}
				populateTable();
			}
			//update human
			else if (event.getSource().equals(button[1])) {
				int num = table1.getSelectionModel().getSelectedIndex();
				Human h = (Human) hController.getHumanList().get(num);
				h.setFirstName(textField[0].getText());
				h.setLastName(textField[1].getText());
				h.setMiddleName(textField[2].getText());
				h.setLogin(textField[3].getText());
				h.setPassword(textField[4].getText());
				hController.updateHuman(h);
				for (int i = 0; i < label.length; i++) {
					textField[i].clear();
				}
				populateTable();
			}
			//delete human
			else if (event.getSource().equals(button[2])) {
				int num = table1.getSelectionModel().getSelectedIndex();
				Human h = (Human) hController.getHumanList().get(num);
				hController.deleteHuman(h.getHumanId());
				populateTable();	
			}
			//clear fields
			else if (event.getSource().equals(button[3])) {
				for (int i = 0; i < label.length; i++) {
					textField[i].clear();
				}
			}
			//add tasks form
			else if (event.getSource().equals(button[4])) {
				new GreateStage2();
		    }
			//add logs form
			else if (event.getSource().equals(button[5])) {
				new GreateStage3();
		    }
					
		
		}
	}

	private void populateTable() {
		table1.getItems().clear();
		table1.setItems(hController.getHumanList());
		table1.setPadding(new Insets(10,10,10,10));

		TableColumn<Human, String> firstNameCol = new TableColumn<Human, String>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Human, String>("firstName"));
		TableColumn<Human, String> lastNameCol = new TableColumn<Human, String>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Human, String>("lastName"));
		TableColumn<Human, String> middleNameCol = new TableColumn<Human, String>("Middle Name");
		middleNameCol.setCellValueFactory(new PropertyValueFactory<Human, String>("middleName"));
		TableColumn<Human, String> loginCol = new TableColumn<Human, String>("Login");
		loginCol.setCellValueFactory(new PropertyValueFactory<Human, String>("login"));
		TableColumn<Human, String> passwordCol = new TableColumn<Human, String>("Password");
		passwordCol.setCellValueFactory(new PropertyValueFactory<Human, String>("password"));
		
		table1.getColumns().setAll(firstNameCol, lastNameCol, middleNameCol, loginCol, passwordCol);
		
	}
	
	private void populateTable2(int id) {
		table2.getItems().clear();
		table2.setItems(tController.getHumanTasksList(id));
		table2.setPadding(new Insets(10,10,10,10));

		TableColumn<Task, String> taskNameCol = new TableColumn<Task, String>("Task");
		taskNameCol.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
		TableColumn<Task, Boolean> statusCol = new TableColumn<Task, Boolean>("Status");
		statusCol.setCellValueFactory(new PropertyValueFactory<Task, Boolean>("status"));
		
		table2.getColumns().setAll(taskNameCol, statusCol);
		
	}
	
	private void populateTable3(int taskId) {
		table3.getItems().clear();
		table3.setItems(lController.getTaskLogsList(taskId));
		table3.setPadding(new Insets(10,10,10,10));
		
		TableColumn<Log, Integer> timeCol = new TableColumn<Log, Integer>("Time");
		timeCol.setCellValueFactory(new PropertyValueFactory<Log, Integer>("time"));
		TableColumn<Log, String> commentCol = new TableColumn<Log, String>("Comment");
		commentCol.setCellValueFactory(new PropertyValueFactory<Log, String>("comment"));
		
		table3.getColumns().setAll(timeCol, commentCol);
		
	}
				
		
		
	

}
